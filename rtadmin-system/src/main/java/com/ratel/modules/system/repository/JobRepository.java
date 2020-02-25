package com.ratel.modules.system.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.system.domain.Job;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends BaseRepository<Job, Long> {
}
