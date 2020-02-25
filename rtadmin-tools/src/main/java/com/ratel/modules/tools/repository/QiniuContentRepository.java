package com.ratel.modules.tools.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.tools.domain.QiniuContent;
import org.springframework.stereotype.Repository;

@Repository
public interface QiniuContentRepository extends BaseRepository<QiniuContent, Long> {

    /**
     * 根据key查询
     *
     * @param key 文件名
     * @return QiniuContent
     */
    QiniuContent findByKey(String key);
}
