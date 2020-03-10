package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpThreePageInvestigation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  疫情工作动态-固定检查点排查
 * @author GXP
 * @date 2020/2/27 17:26
 */
@Repository
public interface YndpThreePageInvestigationRepository extends BaseRepository<YndpThreePageInvestigation, String> {

    /**
     * 根据日期查询固定检查点排查
     */
    @Query(nativeQuery = true, value = "select * from yndp_three_page_investigation where date = ?1 limit 1")
    YndpThreePageInvestigation getYndpThreePageInvestigation(String date);

}
