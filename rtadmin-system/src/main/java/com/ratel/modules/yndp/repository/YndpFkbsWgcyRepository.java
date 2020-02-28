package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFkbsWg;
import com.ratel.modules.yndp.domain.YndpFkbsWgcy;
import org.springframework.stereotype.Repository;

/**
 * 防控部署-网格成员
 * @author DDXS
 * @date 2020/2/28 12:40
 */
@Repository
public interface YndpFkbsWgcyRepository extends BaseRepository<YndpFkbsWgcy, String> {

}
