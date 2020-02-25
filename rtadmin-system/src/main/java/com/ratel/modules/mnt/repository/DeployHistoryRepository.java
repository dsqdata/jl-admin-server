package com.ratel.modules.mnt.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.mnt.domain.DeployHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DeployHistoryRepository extends BaseRepository<DeployHistory, String> {
}
