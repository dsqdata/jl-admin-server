package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpThreePageCheck;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  疫情工作动态-三类重点目标人群核查
 * @author GXP
 * @date 2020/2/27 17:26
 */
@Repository
public interface YndpThreePageCheckRepository extends BaseRepository<YndpThreePageCheck, String> {

    /**
     * 根据日期查询三类重点目标人群核查
     */
    @Query(nativeQuery = true, value = "select * from yndp_three_page_check where date = ?1 limit 1")
    YndpThreePageCheck getYndpThreePageCheck(String date);

}
