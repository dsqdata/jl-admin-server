package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkdcFkxc;
import com.ratel.modules.yndp.domain.YndpFkdcWghpcLflk;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  网格化排查及联防联控
 * @author DDXS
 * @date 2020/2/27 17:26
 */
@Repository
public interface YndpFkdcWghpcLflkRepository extends BaseRepository<YndpFkdcWghpcLflk, String> {

    /**
     * 根据机构ID查询网格化排查及联防联控
     */
//    @Query(nativeQuery = true, value = "select * from yndp_fkdc_wghpclflk where jgid = ?1")
    @Query(nativeQuery = true, value = "select * from yndp_fkdc_wghpclflk where jgid = ?1  ORDER BY field5 desc limit 1")
    List<YndpFkdcWghpcLflk> getPcjlflkList(String jgId);


    @Query(nativeQuery = true, value = "select * from yndp_fkdc_wghpclflk where jgid = ?1  ORDER BY field5 desc")
    List<YndpFkdcWghpcLflk> getPcjlflkListAll(String jgId);

}
