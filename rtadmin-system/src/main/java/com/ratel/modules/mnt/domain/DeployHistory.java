package com.ratel.modules.mnt.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;
import com.ratel.framework.core.domain.BaseUuidEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "mnt_deploy_history")
public class DeployHistory extends BaseUuidEntity {

    /**
     * 应用名称
     */
    @Column(name = "app_name", nullable = false)
    private String appName;

    /**
     * 部署IP
     */
    @Column(name = "ip", nullable = false)
    private String ip;

    /**
     * 部署时间
     */
    @Column(name = "deploy_date")
    @CreationTimestamp
    private Timestamp deployDate;

    /**
     * 部署人员
     */
    @Column(name = "deploy_user", nullable = false)
    private String deployUser;

    /**
     * 部署编号
     */
    @Column(name = "deploy_id", nullable = false)
    private Long deployId;

    public void copy(DeployHistory source) {
        BeanUtil.copyProperties(source, this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
