package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpThreePageReworkEchart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  疫情工作动态-企业复工复产Echart
 * @author GXP
 * @date 2020/2/27 17:26
 */
@Repository
public interface YndpThreePageReworkEchartRepository extends BaseRepository<YndpThreePageReworkEchart, String> {

    /**
     * 根据日期查询之前所有日期的企业复工复产Echart
     */
    @Query(nativeQuery = true, value = "select * from yndp_three_page_rework_echart where date <= ?1 ORDER BY date ASC")
    List<YndpThreePageReworkEchart> getYndpThreePageReworkEchartList(String date);
}
