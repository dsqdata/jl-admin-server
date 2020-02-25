package com.ratel.modules.tools.domain;

import lombok.Data;
import com.ratel.framework.core.domain.BaseNativeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * sm.ms图床
 */
@Data
@Entity
@Table(name = "picture")
public class Picture extends BaseNativeEntity {

    private String filename;

    private String url;

    private String size;

    private String height;

    private String width;

    @Column(name = "delete_url")
    private String delete;

    private String username;

    /**
     * 用于检测文件是否重复
     */
    private String md5Code;

    @Override
    public String toString() {
        return "Picture{" +
                "filename='" + filename + '\'' +
                '}';
    }
}
