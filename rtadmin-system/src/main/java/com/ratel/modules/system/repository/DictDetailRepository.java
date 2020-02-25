package com.ratel.modules.system.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.system.domain.DictDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface DictDetailRepository extends BaseRepository<DictDetail, Long> {
}
