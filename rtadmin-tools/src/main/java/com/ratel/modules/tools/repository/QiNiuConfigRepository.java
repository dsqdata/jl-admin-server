package com.ratel.modules.tools.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.tools.domain.QiniuConfig;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QiNiuConfigRepository extends BaseRepository<QiniuConfig, Long> {

    /**
     * 编辑类型
     *
     * @param type
     */
    @Modifying
    @Query(value = "update QiniuConfig set type = ?1")
    void update(String type);
}
