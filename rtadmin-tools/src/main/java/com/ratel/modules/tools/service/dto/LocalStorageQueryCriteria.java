package com.ratel.modules.tools.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.util.List;

import com.ratel.framework.annotation.Query;

@Data
public class LocalStorageQueryCriteria{

    @Query(blurry = "name,suffix,type,operate,size")
    private String blurry;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
