package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkdcMapSj;
import com.ratel.modules.yndp.domain.YndpFkdcWghpcLflk;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 中间地图下方汇总
 * @author DDXS
 * @date 2020/2/28 9:13
 */
@Repository
public interface YndpFkdcMapSjRepository extends BaseRepository<YndpFkdcMapSj, String> {

    //查询地图下方汇总数据
    @Query(nativeQuery = true, value = "select * from yndp_fkdc_map_sj where jgid = ?1")
    YndpFkdcMapSj getMapHz(String jgId);
}
