package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFiveHubeiCriticalJunctureReturnEchart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  严防外源输入-湖北返回情况echart图表
 * @author GXP
 * @date 2020/2/27 17:26
 */
@Repository
public interface YndpFiveHubeiCriticalJunctureReturnEchartRepository extends BaseRepository<YndpFiveHubeiCriticalJunctureReturnEchart, String> {

    /**
     * 根据日期查询之前所有日期的湖北返回情况echart图表
     */
    @Query(nativeQuery = true, value = "select * from yndp_five_hubei_people_echart where date <= ?1 ORDER BY date ASC")
    List<YndpFiveHubeiCriticalJunctureReturnEchart> getYndpFiveHubeiCriticalJunctureReturnEchartList(String date);
}
