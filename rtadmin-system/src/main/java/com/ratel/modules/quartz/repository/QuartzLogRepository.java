package com.ratel.modules.quartz.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.quartz.domain.QuartzLog;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartzLogRepository extends BaseRepository<QuartzLog,Long> {

}
