package com.ratel.modules.mnt.service.dto;

import lombok.Data;
import com.ratel.framework.annotation.Query;

import java.sql.Timestamp;
import java.util.List;

@Data
public class AppQueryCriteria{

	/**
	 * 模糊
	 */
    @Query(type = Query.Type.INNER_LIKE)
    private String name;

	@Query(type = Query.Type.BETWEEN)
	private List<Timestamp> createTime;
}
