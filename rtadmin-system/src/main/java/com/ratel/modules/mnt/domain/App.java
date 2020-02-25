package com.ratel.modules.mnt.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;
import com.ratel.framework.core.domain.BaseNativeEntity;

import javax.persistence.*;

@Entity
@Data
@Table(name = "mnt_app")
public class App extends BaseNativeEntity {

    /**
     * 应用名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 端口
     */
    @Column(name = "port")
    private int port;

    /**
     * 上传目录
     */
    @Column(name = "upload_path")
    private String uploadPath;

    /**
     * 部署目录
     */
    @Column(name = "deploy_path")
    private String deployPath;

    /**
     * 备份目录
     */
    @Column(name = "backup_path")
    private String backupPath;

    /**
     * 启动脚本
     */
    @Column(name = "start_script")
    private String startScript;

    /**
     * 部署脚本
     */
    @Column(name = "deploy_script")
    private String deployScript;

    public void copy(App source) {
        BeanUtil.copyProperties(source, this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
