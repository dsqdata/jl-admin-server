package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpThreePageLack;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  疫情工作动态-紧缺物资
 * @author GXP
 * @date 2020/2/27 17:26
 */
@Repository
public interface YndpThreePageLackRepository extends BaseRepository<YndpThreePageLack, String> {

    /**
     * 根据日期查询紧缺物资
     */
    @Query(nativeQuery = true, value = "select * from yndp_three_page_lack where date = ?1 order by status desc ")
    List<YndpThreePageLack> getYndpThreePageLackList(String date);

}
