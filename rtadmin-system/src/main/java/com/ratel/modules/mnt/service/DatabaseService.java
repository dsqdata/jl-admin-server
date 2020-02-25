package com.ratel.modules.mnt.service;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import com.ratel.framework.core.service.BaseService;
import com.ratel.modules.mnt.domain.Database;
import com.ratel.modules.mnt.repository.DatabaseRepository;
import com.ratel.modules.mnt.service.dto.DatabaseQueryCriteria;
import com.ratel.modules.mnt.util.SqlUtils;
import com.ratel.framework.utils.FileUtil;
import com.ratel.framework.utils.PageUtil;
import com.ratel.framework.utils.QueryHelp;
import com.ratel.framework.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DatabaseService extends BaseService<Database, String> {

    @Autowired
    private DatabaseRepository databaseRepository;

    public Object queryAll(DatabaseQueryCriteria criteria, Pageable pageable) {
        Page<Database> page = databaseRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page);
    }

    public List<Database> queryAll(DatabaseQueryCriteria criteria) {
        return databaseRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder));
    }

    public Database findById(String id) {
        Database database = databaseRepository.findById(id).orElseGet(Database::new);
        ValidationUtil.isNull(database.getId(), "Database", "id", id);
        return database;
    }

    @Transactional(rollbackFor = Exception.class)
    public Database create(Database resources) {
        resources.setId(IdUtil.simpleUUID());
        return databaseRepository.save(resources);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(Database resources) {
        Database database = databaseRepository.findById(resources.getId()).orElseGet(Database::new);
        ValidationUtil.isNull(database.getId(), "Database", "id", resources.getId());
        database.copy(resources);
        databaseRepository.save(database);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<String> ids) {
        for (String id : ids) {
            databaseRepository.deleteById(id);
        }
    }

    public boolean testConnection(Database resources) {
        try {
            return SqlUtils.testConnection(resources.getJdbcUrl(), resources.getUserName(), resources.getPwd());
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    public void download(List<Database> queryAll, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (Database databaseDto : queryAll) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("数据库名称", databaseDto.getName());
            map.put("数据库连接地址", databaseDto.getJdbcUrl());
            map.put("用户名", databaseDto.getUserName());
            map.put("创建日期", databaseDto.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}
