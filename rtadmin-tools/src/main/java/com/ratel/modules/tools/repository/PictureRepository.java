package com.ratel.modules.tools.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.tools.domain.Picture;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends BaseRepository<Picture, Long> {

    /**
     * 根据 Mds 值查询文件
     *
     * @param code 值
     * @return /
     */
    Picture findByMd5Code(String code);

    /**
     * 根据连接地址查询
     *
     * @param url /
     * @return /
     */
    boolean existsByUrl(String url);
}
