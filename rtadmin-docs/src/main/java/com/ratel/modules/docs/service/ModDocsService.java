package com.ratel.modules.docs.service;

import cn.hutool.core.collection.CollectionUtil;
import com.ratel.framework.core.service.BaseService;
import com.ratel.framework.utils.FileUtil;
import com.ratel.framework.utils.PageUtil;
import com.ratel.framework.utils.QueryHelp;
import com.ratel.modules.docs.domain.ModDocs;
import com.ratel.modules.docs.repository.ModDocsRepository;
import com.ratel.modules.docs.service.dto.ModDocsQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ModDocsService extends BaseService<ModDocs, Long> {

    @Autowired
    private ModDocsRepository modDocsRepository;

    public Map<String, Object> queryAll(ModDocsQueryCriteria modDocs, Pageable pageable) {
        Page<ModDocs> page = modDocsRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, modDocs, cb), pageable);
        return PageUtil.toPage(page);
    }

    public List<ModDocs> queryAll(ModDocsQueryCriteria dict) {
        List<ModDocs> list = modDocsRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, dict, cb));
        return list;
    }

    public void download(List<ModDocs> dictDtos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ModDocs deptDTO : dictDtos) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("部门名称", deptDTO.getName());
            map.put("部门状态", deptDTO.getType());
            map.put("创建日期", deptDTO.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}
