package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpThreePageRework;
import com.ratel.modules.yndp.domain.YndpThreePageSchool;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 企业复工复产情况
 * @author DDXS
 * @date 2020/2/26 9:39
 */
@Repository
public interface YndpQyfgfcRepository extends BaseRepository<YndpThreePageRework, String> {

    /**
     * 企业复工复产情况
     * @author xjl
     * @date 2020/3/9
     */
    @Query(nativeQuery = true, value = "select * from yndp_three_page_rework where DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d')  ORDER BY date desc limit 5")
    List<YndpThreePageRework> getQyfgfcList(String date);

}
