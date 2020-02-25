package com.ratel.framework.core.pagination;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.service.spi.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 用于jqGrid自定义高级查询条件封装条件组合
 */
public class GroupPropertyFilter {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /** 组合类型:AND/OR */
    @Getter
    @Setter
    private GroupOperationEnum groupType = GroupOperationEnum.AND;

    /** 组合条件列表 */
    @Getter
    @Setter
    private List<PropertyFilter> filters = new ArrayList();

    /** 强制追加AND条件列表 */
    private List<PropertyFilter> forceAndFilters = new ArrayList();

    /** 组合条件组 */
    @Getter
    @Setter
    private List<GroupPropertyFilter> groups = new ArrayList();

    @Getter
    @Setter
    private Class<?> entityClass;


    public List<PropertyFilter> getForceAndFilters() {
        return forceAndFilters;
    }

    private GroupPropertyFilter() {
    }

    public GroupPropertyFilter append(GroupPropertyFilter... groups) {
        this.groups.addAll(new ArrayList(Arrays.asList(groups)));
        return this;
    }

    public GroupPropertyFilter append(PropertyFilter... filters) {
        this.filters.addAll(new ArrayList(Arrays.asList(filters)));
        return this;
    }

    public GroupPropertyFilter forceAnd(PropertyFilter... filters) {
        this.forceAndFilters.addAll(new ArrayList(Arrays.asList(filters)));
        return this;
    }

    public static GroupPropertyFilter buildFromHttpRequest(Class<?> entityClass, HttpServletRequest request) {

        try {
            String filtersJson = request.getParameter("filters");

            GroupPropertyFilter groupPropertyFilter = new GroupPropertyFilter();
            groupPropertyFilter.setEntityClass(entityClass);

            if (StringUtils.isNotBlank(filtersJson)) {
                JqGridSearchFilter jqFilter = objectMapper.readValue(filtersJson, JqGridSearchFilter.class);
                convertJqGridToFilter(entityClass, groupPropertyFilter, jqFilter);
            }

            List<PropertyFilter> filters = PropertyFilter.buildFiltersFromHttpRequest(entityClass, request);
            if (CollectionUtils.isNotEmpty(filters)) {

                GroupPropertyFilter comboGroupPropertyFilter = new GroupPropertyFilter();
                comboGroupPropertyFilter.setEntityClass(entityClass);
                comboGroupPropertyFilter.setGroupType(GroupOperationEnum.AND);

                GroupPropertyFilter normalGroupPropertyFilter = new GroupPropertyFilter();
                normalGroupPropertyFilter.setGroupType(GroupOperationEnum.AND);
                normalGroupPropertyFilter.setFilters(filters);
                comboGroupPropertyFilter.getGroups().add(normalGroupPropertyFilter);

                comboGroupPropertyFilter.getGroups().add(groupPropertyFilter);
                return comboGroupPropertyFilter;
            }

            return groupPropertyFilter;

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public static GroupPropertyFilter buildDefaultAndGroupFilter(PropertyFilter... filters) {
        GroupPropertyFilter dpf = new GroupPropertyFilter();
        dpf.setGroupType(GroupOperationEnum.AND);
        if (filters != null && filters.length > 0) {
            dpf.setFilters(new ArrayList(Arrays.asList(filters)));
        }
        return dpf;
    }

    public static GroupPropertyFilter buildDefaultOrGroupFilter(PropertyFilter... filters) {
        GroupPropertyFilter dpf = new GroupPropertyFilter();
        dpf.setGroupType(GroupOperationEnum.OR);
        if (filters != null && filters.length > 0) {
            dpf.setFilters(new ArrayList(Arrays.asList(filters)));
        }
        return dpf;
    }

    private static void convertJqGridToFilter(Class<?> entityClass, GroupPropertyFilter jqGroupPropertyFilter, JqGridSearchFilter jqFilter) {
        jqGroupPropertyFilter.setGroupType("OR".equalsIgnoreCase(jqFilter.getGroupOp()) ? GroupOperationEnum.OR : GroupOperationEnum.AND);

        List<JqGridSearchRule> rules = jqFilter.getRules();
        List<PropertyFilter> filters = new ArrayList();
        for (JqGridSearchRule rule : rules) {
            if (StringUtils.isBlank(rule.getData())) {
                continue;
            }
            PropertyFilter filter = new PropertyFilter(entityClass, rule.getOp().toUpperCase() + "_" + rule.getField(), rule.getData());
            filters.add(filter);
        }
        jqGroupPropertyFilter.setFilters(filters);

        List<JqGridSearchFilter> groups = jqFilter.getGroups();
        for (JqGridSearchFilter group : groups) {
            GroupPropertyFilter jqChildGroupPropertyFilter = new GroupPropertyFilter();
            jqGroupPropertyFilter.getGroups().add(jqChildGroupPropertyFilter);
            convertJqGridToFilter(entityClass, jqChildGroupPropertyFilter, group);
        }
    }

    /**
     * filters =
     * {"groupOp":"AND","rules":[{"field":"code","op":"eq","data":"123"}]}
     */
    @Getter
    @Setter
    public static class JqGridSearchFilter {
        private String groupOp;
        private List<JqGridSearchRule> rules = new ArrayList();
        private List<JqGridSearchFilter> groups = new ArrayList();
    }

    @Getter
    @Setter
    public static class JqGridSearchRule {
        /** 查询字段 */
        private String field;

        /**
         * 查询匹配规则
         * [
         * 'eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc'
         * ] The corresponding texts are in language file and mean the
         * following: ['equal','not equal', 'less', 'less or
         * equal','greater','greater or equal', 'begins with','does not begin
         * with','is in','is not in','ends with','does not end
         * with','contains','does not contain']
         */
        private String op;

        /** 查询数据 */
        private String data;
    }

    /**
     * 判断当前是没有提供任何参数的默认查询
     * 一般用于父子结构类型数据根据无参数判断追加parent==null的查询条件
     *
     * @return
     */
    public boolean isEmptySearch() {
        if (CollectionUtils.isEmpty(filters) && CollectionUtils.isEmpty(groups)) {
            return true;
        }
        Set<PropertyFilter> mergeFileters = new HashSet();
        mergeFileters.addAll(filters);
        for (GroupPropertyFilter group : groups) {
            mergeFileters.addAll(group.getFilters());
            mergeFileters.addAll(group.getForceAndFilters());
        }
        for (PropertyFilter filter : mergeFileters) {
            //FETCH类型不算有效的查询条件，忽略掉
            if (!filter.getMatchType().equals(PropertyFilter.MatchType.FETCH)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 转换为Key-Value的Map结构数据
     *
     * @return
     */
    public Map<String, Object> convertToMapParameters() {
        Map<String, Object> parameters = new HashMap();
        List<PropertyFilter> propertyFilters = new ArrayList();
        propertyFilters.addAll(this.getFilters());
        if (CollectionUtils.isNotEmpty(this.getGroups())) {
            for (GroupPropertyFilter group : this.getGroups()) {
                if (CollectionUtils.isEmpty(group.getFilters()) && CollectionUtils.isEmpty(group.getForceAndFilters())) {
                    continue;
                }
                propertyFilters.addAll(group.getFilters());
            }
        }
        for (PropertyFilter propertyFilter : propertyFilters) {
            String name = propertyFilter.getConvertedPropertyName();
            //把.分隔转换为_形式，以便在MyBatis中引用
            name = name.replaceAll("\\.", "_");
            parameters.put(name, propertyFilter.getMatchValue());
        }
        return parameters;
    }

    /**
     * 转换为PropertyFilter查询集合，用于传递给MyBatis作为动态查询参数
     * 注意限制：仅考虑最常用的一个层次的查询调整合并处理，暂不支持复杂的多级嵌套层次查询
     *
     * @return
     */
    public List<PropertyFilter> convertToPropertyFilters() {
        List<PropertyFilter> propertyFilters = new ArrayList();
        propertyFilters.addAll(this.getFilters());
        if (CollectionUtils.isNotEmpty(this.getGroups())) {
            for (GroupPropertyFilter group : this.getGroups()) {
                if (CollectionUtils.isEmpty(group.getFilters()) && CollectionUtils.isEmpty(group.getForceAndFilters())) {
                    continue;
                }
                propertyFilters.addAll(group.getFilters());
            }
        }
        return propertyFilters;
    }

    public enum GroupOperationEnum {
        AND, OR
    }
}
