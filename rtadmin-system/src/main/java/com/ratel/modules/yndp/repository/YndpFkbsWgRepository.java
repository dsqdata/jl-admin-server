package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkbsJg;
import com.ratel.modules.yndp.domain.YndpFkbsWg;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 防控部署-网格
 * @author DDXS
 * @date 2020/2/28 12:40
 */
@Repository
public interface YndpFkbsWgRepository extends BaseRepository<YndpFkbsWg, String> {

    @Query(nativeQuery = true, value = "select * from yndp_fkbs_wg where jgid = ?1")
    List<YndpFkbsWg> getWgList(String jgId);
}
