package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFiveHubeiCarPeopleEchart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  严防外源输入-湖北入昆车辆人员图表
 * @author GXP
 * @date 2020/2/27 17:26
 */
@Repository
public interface YndpFiveHubeiCarPeopleEchartRepository extends BaseRepository<YndpFiveHubeiCarPeopleEchart, String> {

    /**
     * 根据日期查询之前所有日期的湖北入昆车辆人员图表
     */
    @Query(nativeQuery = true, value = "select * from yndp_five_hubei_car_people_echart where date <= ?1 ORDER BY date ASC")
    List<YndpFiveHubeiCarPeopleEchart> getYndpFiveHubeiCarPeopleEchartList(String date);
}
