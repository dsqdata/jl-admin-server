package com.ratel.modules.updata.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.ratel.framework.core.domain.BaseNativeEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "mod_yqpc_main")
public class YqpcMain extends BaseNativeEntity {

    @Column(name = "name", columnDefinition = "varchar(255) COMMENT '文档名称'")
    private String name;

    @Column(name = "type", columnDefinition = "varchar(255) COMMENT '文档类别'")
    private String type;

    @Column(name = "content", columnDefinition = "text COMMENT '文档内容'")
    private String content;

    @Column(name = "filepath", columnDefinition = "LONGTEXT COMMENT '文档路径'")
    private String filepath;

    public void copy(YqpcMain source) {
        BeanUtil.copyProperties(source, this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
