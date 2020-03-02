package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkbsJg;
import com.ratel.modules.yndp.domain.YndpSjgxsj;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 数据更新时间
 * @author DDXS
 * @date 2020/3/2 16:21
 */
@Repository
public interface YndpSjgxsjRepository extends BaseRepository<YndpSjgxsj, String> {

    // 获取数据更新时间
    @Query(nativeQuery = true, value = "select * from yndp_sjgxsj LIMIT 1")
    YndpSjgxsj getGxsj();
}
