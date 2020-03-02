package com.ratel.modules.updata.service.dto;

import com.ratel.framework.annotation.Query;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Data
public class YqpcQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;

    @Query(type = Query.Type.IN, propName="systemDeptId")
    private Set<Long> systemDeptIds;
}
