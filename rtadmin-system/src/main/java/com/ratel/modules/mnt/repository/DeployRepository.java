package com.ratel.modules.mnt.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.mnt.domain.Deploy;
import org.springframework.stereotype.Repository;

@Repository
public interface DeployRepository extends BaseRepository<Deploy, Long> {
}
