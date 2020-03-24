package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFourDate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 *  校园疫情防控-数据更新时间
 * @author GXP
 * @date 2020/2/27 17:26
 */
@Repository
public interface YndpFourDateRepository extends BaseRepository<YndpFourDate, String> {

    /**
     * 根据日期查询紧缺物资
     */
    @Query(nativeQuery = true, value = "select * from yndp_four_date order by date desc limit 1")
    YndpFourDate getYndpFourDate();

}
