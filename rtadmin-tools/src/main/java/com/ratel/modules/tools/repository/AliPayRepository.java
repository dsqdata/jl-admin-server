package com.ratel.modules.tools.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.tools.domain.AlipayConfig;
import org.springframework.stereotype.Repository;

@Repository
public interface AliPayRepository extends BaseRepository<AlipayConfig, Long> {
}
