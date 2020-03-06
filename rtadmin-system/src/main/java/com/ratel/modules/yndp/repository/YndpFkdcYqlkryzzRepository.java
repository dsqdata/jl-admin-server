package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkdcYqlkryzz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YndpFkdcYqlkryzzRepository extends BaseRepository<YndpFkdcYqlkryzz,String> {

    /**
     * 获得一个时间段的记录
     * @param date1 日期1
     * @param date2 日期2
     * @param jgid  机构ID
     * @return List
     */
    @Query(value = "select sum(rysl) AS rysl,rylx FROM yndp_fkdc_yqlkryzz where rq between STR_TO_DATE(?1,'%Y-%m-%d') and STR_TO_DATE(?2,'%Y-%m-%d')  and jgid=?3 GROUP by rylx ORDER BY px",nativeQuery = true)
    List<YndpFkdcYqlkryzz> findYqlkryzz(String date1, String date2, String jgid);

    /**
     * 获得时间段每日数据记录
     * @param date1 日期1
     * @param date2 日期2
     * @param jgid  机构ID
     * @return List
     */
    @Query(value = "select * FROM yndp_fkdc_yqlkryzz where rq between STR_TO_DATE(?1,'%Y-%m-%d') and STR_TO_DATE(?2,'%Y-%m-%d') and jgid= ?3 and rylx = '总数' ORDER BY str_to_date(rq, '%Y-%m-%d')",nativeQuery = true)
    List<YndpFkdcYqlkryzz> findDayData(String date1, String date2,String jgid);


    /**
     * 获得时间段每日数据记录
     * @param jgid  机构ID
     * @return List
     */
    @Query(value = "SELECT * FROM yndp_fkdc_yqlkryzz WHERE DATE_FORMAT(rq, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') AND jgid= ?2 ORDER BY px",nativeQuery = true)
    List<YndpFkdcYqlkryzz> getSameDay(String data,String jgid);
}
