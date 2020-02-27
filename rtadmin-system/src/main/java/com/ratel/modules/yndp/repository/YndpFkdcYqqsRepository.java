package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkdcYqqs;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YndpFkdcYqqsRepository extends BaseRepository<YndpFkdcYqqs,Long> {

    /**
     * 获得一个时间段的记录
     * @param date1 日期1
     * @param date2 日期2
     * @return List
     */
    @Query(value = "select * FROM yndp_fkdc_yqqs where rq between ?1 and ?2",nativeQuery = true)
    List<YndpFkdcYqqs> findYqqs(String date1, String date2);
}
