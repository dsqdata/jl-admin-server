package com.ratel.modules.tools.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.tools.domain.EmailConfig;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends BaseRepository<EmailConfig, Long> {
}
