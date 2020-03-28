package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFiveHubeiPeople;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *  严防外源输入-湖北入昆人员
 * @author GXP
 * @date 2020/2/27 17:26
 */
@Repository
public interface YndpFiveHubeiPeopleRepository extends BaseRepository<YndpFiveHubeiPeople, String> {

    /**
     * 严防外源输入-湖北入昆人员
     */
    @Query(nativeQuery = true, value = "select * from yndp_five_hubei_people where date = ?1 limit 1")
    YndpFiveHubeiPeople getYndpFiveHubeiPeople(String date);

}
