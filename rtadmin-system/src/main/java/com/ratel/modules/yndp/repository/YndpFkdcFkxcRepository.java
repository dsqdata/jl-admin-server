package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkdcFkxc;
import com.ratel.modules.yndp.domain.YndpFkdcWzbz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 防控宣传
 * @author DDXS
 * @date 2020/2/26 9:39
 */
@Repository
public interface YndpFkdcFkxcRepository extends BaseRepository<YndpFkdcFkxc, String> {

    /**
     * 根据机构ID查询防控宣传
     */
//    @Query(nativeQuery = true, value = "select * from yndp_fkdc_fkxc where jgid = ?1")
    @Query(nativeQuery = true, value = "select * from yndp_fkdc_fkxc where jgid = ?1  ORDER BY field1 desc limit 1")
    List<YndpFkdcFkxc> getFkxcList(String jgId);

}
