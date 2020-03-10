package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpThreePageBroadcast;
import com.ratel.modules.yndp.domain.YndpThreePageSituation;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 第三屏：其他疫情信息播报
 * @author DDXS
 * @date 2020/3/9 14:19
 */
public interface YndpThreePageBroadcastRepository extends BaseRepository<YndpThreePageBroadcast, String> {

    // 根据时间查询其他疫情信息播报
    @Query(nativeQuery = true, value = "select * from yndp_three_page_broadcast where date = ?1")
    List<YndpThreePageBroadcast> getBroadcast(String date);
}
