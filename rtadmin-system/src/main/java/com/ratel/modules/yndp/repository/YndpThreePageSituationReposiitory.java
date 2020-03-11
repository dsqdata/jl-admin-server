package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkbsJg;
import com.ratel.modules.yndp.domain.YndpThreePageSituation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 第三屏：当日疫情动态
 * @author DDXS
 * @date 2020/3/9 14:17
 */
@Repository
public interface YndpThreePageSituationReposiitory extends BaseRepository<YndpThreePageSituation, String> {

    // 根据时间查询当日疫情动态
    @Query(nativeQuery = true, value = "select * from yndp_three_page_situation where date = ?1")
    List<YndpThreePageSituation> getSituation(String date);
    // 发热门诊接触弹出图表List
//    @Query(nativeQuery = true, value = "select * from yndp_three_page_situation where date between STR_TO_DATE(?1,'%Y%m%d')-7 and STR_TO_DATE(?1,'%Y%m%d') order by date asc ")
    @Query(nativeQuery = true, value = "select * from yndp_three_page_situation where date <= STR_TO_DATE(?1,'%Y%m%d') order by date asc ")
    List<YndpThreePageSituation> getReceive(String date);
}
