package com.ratel.modules.monitor.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.monitor.domain.Server;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepository extends BaseRepository<Server, Integer> {
}
