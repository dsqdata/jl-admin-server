package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkdcMap;
import com.ratel.modules.yndp.domain.YndpFkdcMapSj;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 中间地图
 * @author DDXS
 * @date 2020/2/28 9:13
 */
@Repository
public interface YndpFkdcMapRepository extends BaseRepository<YndpFkdcMap, String> {

    @Query(nativeQuery = true, value = "select a.id,a.jgid,a.jdwggly,a.jdwgz,a.jg_or_hy,a.jglx,a.jgmc,a.parentid,a.qjlxbm,a.qjwgy,a.qjwgz,a.sqwggly,a.sqwgz,a.wd,a.wgz,a.xjlx,a.zhbfzhz,a.zhbzhz,b.hs,b.ljqzs,b.qzlx,b.rs,b.xcqzs,b.yqlkrs FROM yndp_fkbs_jg a LEFT JOIN yndp_fkdc_map b ON a.jgid = b.jgid WHERE a.parentid = ?1 and b.qzlx=?2 and jg_or_hy='1'")
    List<Map> getMapList(String jgId, String qzlx);

}
