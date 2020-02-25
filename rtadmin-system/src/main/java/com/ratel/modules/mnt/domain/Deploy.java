package com.ratel.modules.mnt.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.CollectionUtil;
import lombok.Data;
import com.ratel.framework.core.domain.BaseNativeEntity;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "mnt_deploy")
public class Deploy extends BaseNativeEntity {

    /**
     * 应用编号
     */
    @ManyToOne
    @JoinColumn(name = "app_id")
    private App app;

    /**
     * 服务器
     */
    @ManyToMany
    @JoinTable(name = "mnt_deploy_server", joinColumns = {@JoinColumn(name = "deploy_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "server_id", referencedColumnName = "id")})
    private Set<ServerDeploy> deploys;

    public void copy(Deploy source) {
        BeanUtil.copyProperties(source, this, CopyOptions.create().setIgnoreNullValue(true));
    }

    @Transient
    private String servers;

    public String getServers() {
        if (CollectionUtil.isNotEmpty(deploys)) {
            return deploys.stream().map(ServerDeploy::getName).collect(Collectors.joining(","));
        }
        return servers;
    }
}
