package com.ratel.modules.monitor.service.dto;

import lombok.Data;
import com.ratel.framework.annotation.Query;

@Data
public class ServerQueryCriteria{

    @Query(blurry = "name,address")
    private String blurry;
}
