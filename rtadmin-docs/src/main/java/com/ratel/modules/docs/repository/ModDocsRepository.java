package com.ratel.modules.docs.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.docs.domain.ModDocs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ModDocsRepository extends BaseRepository<ModDocs, Long> {

    @Query("select s from ModDocs s where s.id = :id")
    Page<ModDocs> selectAllByUserId(@Param("id") Integer userId, Pageable pageable);

}
