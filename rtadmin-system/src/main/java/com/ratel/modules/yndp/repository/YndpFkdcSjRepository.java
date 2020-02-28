package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkdcMap;
import com.ratel.modules.yndp.domain.YndpFkdcMapSj;
import com.ratel.modules.yndp.domain.YndpFkdcSj;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 中间地图事件
 * @author DDXS
 * @date 2020/2/28 9:13
 */
@Repository
public interface YndpFkdcSjRepository extends BaseRepository<YndpFkdcSj, String> {

    //根据机构id查询出中间地图事件
    @Query(nativeQuery = true, value = "select * from yndp_fkdc_sj where jgid = ?1")
    List<YndpFkdcSj> getMapSjList(String jgId);

}
