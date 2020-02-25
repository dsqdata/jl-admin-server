package com.ratel.modules.tools.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.tools.domain.LocalStorage;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalStorageRepository extends BaseRepository<LocalStorage, Long> {
}
