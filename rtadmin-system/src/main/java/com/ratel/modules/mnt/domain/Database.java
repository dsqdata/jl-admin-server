package com.ratel.modules.mnt.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;
import com.ratel.framework.core.domain.BaseUuidEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "mnt_database")
public class Database extends BaseUuidEntity {

    /**
     * 数据库名称
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 数据库连接地址
     */
    @Column(name = "jdbc_url", nullable = false)
    private String jdbcUrl;

    /**
     * 数据库密码
     */
    @Column(name = "pwd", nullable = false)
    private String pwd;

    /**
     * 用户名
     */
    @Column(name = "user_name", nullable = false)
    private String userName;

    public void copy(Database source) {
        BeanUtil.copyProperties(source, this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
