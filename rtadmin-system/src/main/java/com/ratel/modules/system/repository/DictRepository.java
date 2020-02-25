package com.ratel.modules.system.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.system.domain.Dict;
import org.springframework.stereotype.Repository;

@Repository
public interface DictRepository extends BaseRepository<Dict, Long> {
}
