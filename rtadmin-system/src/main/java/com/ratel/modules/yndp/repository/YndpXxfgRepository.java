package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkdcFkxc;
import com.ratel.modules.yndp.domain.YndpThreePageSchool;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 学校复工情况
 * @author xjl
 * @date 2020/3/9
 */
@Repository
public interface YndpXxfgRepository extends BaseRepository<YndpThreePageSchool, String> {

    /**
     * 学校复工情况
     * @author xjl
     * @date 2020/3/9
     */
    @Query(nativeQuery = true, value = "select * from yndp_three_page_school where DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d')  ORDER BY date desc limit 1")
    YndpThreePageSchool getXxfgList(String date);

}
