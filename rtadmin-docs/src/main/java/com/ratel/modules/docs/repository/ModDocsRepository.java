package com.ratel.modules.docs.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.docs.domain.ModDocs;
import org.springframework.stereotype.Repository;

@Repository
public interface ModDocsRepository extends BaseRepository<ModDocs, Long> {

}
