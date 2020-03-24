package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFourSchoolMsg;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  校园疫情防控-学校疫情信息
 * @author GXP
 * @date 2020/2/27 17:26
 */
@Repository
public interface YndpFourSchoolMsgRepository extends BaseRepository<YndpFourSchoolMsg, String> {

    /**
     * 1.有学校ID，根据日期和学校ID和人员类型查询学校疫情信息
     */
    @Query(nativeQuery = true, value = "select * from yndp_four_school_msg where date = ?1 and school_id = ?2 limit 1")
    YndpFourSchoolMsg getYndpFourSchoolMsg(String date, String school_id);

    /**
     * 3.有学校ID，根据日期和学校ID和人员类型查询留验站工作动态Echart图
     */
    @Query(nativeQuery = true, value = "select * from yndp_three_page_workstation_total where date <= ?1 and school_id  = ?2 ORDER BY date ASC ")
    List<YndpFourSchoolMsg> getYndpFourSchoolMsgList(String date,String school_id);

}
