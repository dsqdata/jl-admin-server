package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpThreePageSupport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  疫情工作动态-物资保供
 * @author GXP
 * @date 2020/2/27 17:26
 */
@Repository
public interface YndpThreePageSupportRepository extends BaseRepository<YndpThreePageSupport, String> {

    /**
     * 根据日期查询物资保供
     */
    @Query(nativeQuery = true, value = "select * from yndp_three_page_support where date = ?1 limit 1")
    YndpThreePageSupport getYndpThreePageSupport(String date);

}
