package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpThreePageWorkstationTotal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  疫情工作动态-留验站工作动态
 * @author GXP
 * @date 2020/2/27 17:26
 */
@Repository
public interface YndpThreePageWorkstationTotalRepository extends BaseRepository<YndpThreePageWorkstationTotal, String> {

    /**
     * 根据日期和留验站ID查询留验站工作动态
     */
    @Query(nativeQuery = true, value = "select * from yndp_three_page_workstation_total where date = ?1 and workstation_id = ?2 limit 1")
    YndpThreePageWorkstationTotal getYndpThreePageWorkstationTotal(String date, String workstation_id);

    /**
     * 根据日期和留验站ID查询留验站工作动态Echart图
     */
    @Query(nativeQuery = true, value = "select * from yndp_three_page_workstation_total where date <= ?1 ORDER BY date ASC ")
    List<YndpThreePageWorkstationTotal> getYndpThreePageWorkstationTotalList(String date);

}
