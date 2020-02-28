package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkdcYqqs;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YndpFkdcYqqsRepository extends BaseRepository<YndpFkdcYqqs,String> {

    /**
     * 获得一个时间段的记录
     * @param date1 日期1
     * @param date2 日期2
     * @param yqlx  疫情类型
     * @param jgid  机构ID
     * @return List
     */
    @Query(value = "select * FROM yndp_fkdc_yqqs where rq between STR_TO_DATE(?1,'%Y-%m-%d') and STR_TO_DATE(?2,'%Y-%m-%d') and yqlx= ?3 and jgid=?4 ORDER BY str_to_date(rq, '%Y-%m-%d')",nativeQuery = true)
    List<YndpFkdcYqqs> findYqqs(String date1, String date2,String yqlx,String jgid);

    /**
     * 获得所有时间段的记录
     * @param yqlx  疫情类型
     * @param jgid  机构ID
     * @return List
     */
    @Query(value = "select * FROM yndp_fkdc_yqqs where yqlx= ?1 and jgid= ?2 ORDER BY str_to_date(rq, '%Y-%m-%d')",nativeQuery = true)
    List<YndpFkdcYqqs> findYqqs(String yqlx,String jgid);
}
