package com.ratel.modules.system.service.dto;

import lombok.Data;
import com.ratel.framework.annotation.Query;

@Data
public class DictQueryCriteria {

    @Query(blurry = "name,remark")
    private String blurry;
}
