package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkbsJg;
import com.ratel.modules.yndp.domain.YndpFkdcWzbz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 防控部署-机构
 * @author DDXS
 * @date 2020/2/28 12:40
 */
@Repository
public interface YndpFkbsJgRepository  extends BaseRepository<YndpFkbsJg, String> {

    // 根据机构ID查询出机构
    @Query(nativeQuery = true, value = "select * from yndp_fkbs_jg where jgid = ?1")
    YndpFkbsJg getJg(String jgId);


    // 根据机构ID查询出下级机构列表
    @Query(nativeQuery = true, value = "select * from yndp_fkbs_jg where parent_id = ?1")
    List<YndpFkbsJg> getXjJgList(String jgId);

    // 查询出一屏页面所有机构
    @Query(nativeQuery = true, value = "select * from yndp_fkbs_jg where jglx in(0,1,2)")
    List<YndpFkbsJg> getAllJg();

    //  //根据机构名称查询出机构Id
    @Query(nativeQuery = true, value = "select * from yndp_fkbs_jg where jgmc=?1")
    YndpFkbsJg getJgId(String jgmc);
}
