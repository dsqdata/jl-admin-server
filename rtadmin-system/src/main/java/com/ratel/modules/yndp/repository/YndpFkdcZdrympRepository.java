package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkdcZdrymp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YndpFkdcZdrympRepository extends BaseRepository<YndpFkdcZdrymp,String> {

    /**
     * 获得重点人员摸排记录
     * @param rylx 人员类型
     * @param jgid 机构ID
     * @return List
     */
    @Query(value = "select * FROM yndp_fkdc_zdrymp where zdrylx = ?1 and jgid = ?2 and DATE_FORMAT(field4, 'Y%m%d') = DATE_FORMAT(?3, 'Y%m%d')",nativeQuery = true)
    List<YndpFkdcZdrymp> findZdrymp(String rylx, String jgid,String rq);

    /**
     * 获得最大日期
     */
    @Query(value = "select max(field4)  rq FROM yndp_fkdc_zdrymp  where zdrylx = ?1 and jgid = ?2",nativeQuery = true)
    String getMaxDay(String rylx, String jgid);
}
