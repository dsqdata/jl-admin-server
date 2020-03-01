package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkbsWg;
import com.ratel.modules.yndp.domain.YndpFkbsWgcy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 防控部署-网格成员
 * @author DDXS
 * @date 2020/2/28 12:40
 */
@Repository
public interface YndpFkbsWgcyRepository extends BaseRepository<YndpFkbsWgcy, String> {

    // 根据网格ID查询出网格成员列表
    @Query(nativeQuery = true, value = "select * from yndp_fkbs_wgcy where wgid = ?1")
    List<YndpFkbsWgcy> getWgcyList(String wgId);
}
