package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpOneLeadingGroup;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

/**
 * 第一屏-应对疫情工作领导小组Repository
 * @author DDXS
 * @date 2020/3/17 15:56
 */
@Repository
public interface YndpOneLeadingGroupRepository extends BaseRepository<YndpOneLeadingGroup, String> {

    // 根据类型查询应对疫情工作领导小组和指挥部数据
    @Query(nativeQuery = true, value = "select * from yndp_one_page_leading_group where type = ?1")
    List<YndpOneLeadingGroup> findYqgzldxzOrZhbByType(String type);
}
