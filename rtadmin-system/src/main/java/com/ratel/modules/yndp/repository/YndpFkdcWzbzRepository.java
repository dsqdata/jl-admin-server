package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkdcWzbz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 物资保障
 *
 * @author DDXS
 * @date 2020/2/26 9:39
 */
@Repository
public interface YndpFkdcWzbzRepository extends BaseRepository<YndpFkdcWzbz, String> {

    /**
     * 根据机构ID查询资源配置
     */
    @Query(nativeQuery = true, value = "select * from yndp_fkdc_wzbz where jgid = ?1 order by str_to_date(rq, '%Y-%m-%d') desc LIMIT 5")
    List<YndpFkdcWzbz> findWzbzListByJgId(String jgId);
}
