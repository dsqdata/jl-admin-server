package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpThreePageCollection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  疫情工作动态-社区/村人员核查和信息采集
 * @author GXP
 * @date 2020/2/27 17:26
 */
@Repository
public interface YndpThreePageCollectionRepository extends BaseRepository<YndpThreePageCollection, String> {

    /**
     * 根据日期查询社区/村人员核查和信息采集
     */
    @Query(nativeQuery = true, value = "select * from yndp_three_page_collection where date = ?1 limit 1")
    YndpThreePageCollection getYndpThreePageCollection(String date);


    /**
     * 根据日期查询之前所有日期的社区/村人员核查和信息采集
     */
    @Query(nativeQuery = true, value = "select * from yndp_three_page_collection where date <= ?1 ")
    List<YndpThreePageCollection> getYndpThreePageAllCollectionList(String date);
}
