package com.ratel.modules.tools.domain;

import lombok.Data;
import com.ratel.framework.core.domain.BaseNativeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 上传成功后，存储结果
 */
@Data
@Entity
@Table(name = "qiniu_content")
public class QiniuContent extends BaseNativeEntity {

    /**
     * 文件名
     */
    @Column(name = "name")
    private String key;

    /**
     * 空间名
     */
    private String bucket;

    /**
     * 大小
     */
    private String size;

    /**
     * 文件地址
     */
    private String url;

    private String suffix;

    /**
     * 空间类型：公开/私有
     */
    private String type = "公开";

}
