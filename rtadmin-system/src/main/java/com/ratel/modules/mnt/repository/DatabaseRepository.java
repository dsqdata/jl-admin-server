package com.ratel.modules.mnt.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.mnt.domain.Database;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseRepository extends BaseRepository<Database, String> {
}
