package com.ratel.modules.mnt.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.ratel.framework.core.domain.BaseNativeEntity;

import javax.persistence.*;

@Entity
@Data
@Table(name="mnt_server")
public class ServerDeploy extends BaseNativeEntity {

    private String name;

    private String ip;

    private Integer port;

    private String account;

    private String password;

    public void copy(ServerDeploy source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
