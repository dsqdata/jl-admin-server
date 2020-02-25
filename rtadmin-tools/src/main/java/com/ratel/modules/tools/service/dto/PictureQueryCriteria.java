package com.ratel.modules.tools.service.dto;

import lombok.Data;
import com.ratel.framework.annotation.Query;

import java.sql.Timestamp;
import java.util.List;

/**
 * sm.ms图床
 */
@Data
public class PictureQueryCriteria{

    @Query(type = Query.Type.INNER_LIKE)
    private String filename;

    @Query(type = Query.Type.INNER_LIKE)
    private String username;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
