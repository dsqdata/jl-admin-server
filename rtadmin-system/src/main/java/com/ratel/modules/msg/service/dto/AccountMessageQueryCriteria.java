package com.ratel.modules.msg.service.dto;

import com.ratel.framework.annotation.Query;
import com.ratel.modules.system.domain.User;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class AccountMessageQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String title;

    @Query(type = Query.Type.EQUAL)
    private User targetAccount;

    @Query(type = Query.Type.EQUAL)
    private Long createAccountId;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
