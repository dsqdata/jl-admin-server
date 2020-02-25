package com.ratel.modules.mnt.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.mnt.domain.App;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends BaseRepository<App, Long> {
}
