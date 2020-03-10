package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpThreePageWorkstation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  疫情工作动态-留验站工作表
 * @author GXP
 * @date 2020/2/27 17:26
 */
@Repository
public interface YndpThreePageWorkstationRepository extends BaseRepository<YndpThreePageWorkstation, String> {

    /**
     * 留验站工作表
     */
    @Query(nativeQuery = true, value = "select * from yndp_three_page_workstation")
    List<YndpThreePageWorkstation> getYndpThreePageWorkstationList();

}
