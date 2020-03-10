package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpThreePageSupervisor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 督导组工作开展
 * @author xjl
 * @date 2020/3/9
 */
@Repository
public interface YndpDcgzRepository extends BaseRepository<YndpThreePageSupervisor, String> {

    /**
     * 督导组工作开展
     * @author xjl
     * @date 2020/3/9
     */
    @Query(nativeQuery = true, value = "select * from yndp_three_page_supervisor where DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') and type=?2  ORDER BY date desc limit 1")
    YndpThreePageSupervisor getDcgzList(String date, String type);

}
