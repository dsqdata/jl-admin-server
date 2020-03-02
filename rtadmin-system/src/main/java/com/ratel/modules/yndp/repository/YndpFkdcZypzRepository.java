package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkdcZypz;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 资源配置
 * @author DDXS
 * @date 2020/2/26 13:31
 */
public interface YndpFkdcZypzRepository extends BaseRepository<YndpFkdcZypz, String> {

    /**
     * 根据机构ID查询资源配置
     */
    @Query(nativeQuery = true, value = "select * from yndp_fkdc_zypz where jgid = ?1")
    YndpFkdcZypz findZypzByJgId(String jgId);

    /**
     * 根据机构ID查询资源配置
     */
    List<YndpFkdcZypz> findYndpFkdcZypzsByJgid(String jgId);

    /**
     * 根据机构ID查询资源配置
     */
    @Query("from YndpFkdcZypz where jgid = ?1")
    List<YndpFkdcZypz> findListByJgIdWithHsql(String jgId);

}
