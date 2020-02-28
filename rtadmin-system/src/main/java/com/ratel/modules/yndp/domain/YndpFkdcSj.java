package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 防控洞察-事件表
 * @author DDXS
 * @date 2020/2/26 11:07
 */
@Data
@Entity
@Table(name = "yndp_fkdc_sj")
public class YndpFkdcSj extends BaseUuidEntity {

    /**
     * 机构ID
     */
    @Column(name = "jgid", columnDefinition = "VARCHAR(64) COMMENT '机构ID'")
    private String jgid;
    /**
     * 机构名称
     */
    @Column(name = "jgmc", columnDefinition = "VARCHAR(64) COMMENT '机构名称'")
    private String jgmc;

    /**
     * 事件
     */
    @Column(name = "sj", columnDefinition = "VARCHAR(64) COMMENT '事件'")
    private String sj;
    /**
     * 事件发生时间
     */
    @Column(name = "sjfssj", columnDefinition = "VARCHAR(20) COMMENT '事件发生时间'")
    private String sjfssj;

    /**
     * 预留字段1
     */
    @Column(name = "field1", columnDefinition = "VARCHAR(255) COMMENT '预留字段1'")
    private String field1;
    /**
     * 预留字段2
     */
    @Column(name = "field2", columnDefinition = "VARCHAR(255) COMMENT '预留字段2'")
    private String field2;
    /**
     * 预留字段3
     */
    @Column(name = "field3", columnDefinition = "VARCHAR(255) COMMENT '预留字段3'")
    private String field3;
    /**
     * 预留字段4
     */
    @Column(name = "field4", columnDefinition = "VARCHAR(255) COMMENT '预留字段4'")
    private String field4;
    /**
     * 预留字段5
     */
    @Column(name = "field5", columnDefinition = "VARCHAR(255) COMMENT '预留字段5'")
    private String field5;


}
