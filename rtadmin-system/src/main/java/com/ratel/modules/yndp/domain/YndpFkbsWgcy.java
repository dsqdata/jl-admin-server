package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseNativeEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 防控部署-网格成员
 * 020/2/27 9:25
 */
@Data
@Entity
@Table(name = "yndp_fkbs_wgcy")
public class YndpFkbsWgcy extends BaseNativeEntity {
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
     * 楼栋号
     */
    @Column(name = "ldh", columnDefinition = "VARCHAR(64) COMMENT '楼栋号'")
    private String ldh;

    /**
     * 楼栋户数
     */
    @Column(name = "hs", columnDefinition = "VARCHAR(64) COMMENT '楼栋户数'")
    private String hs;

    /**
     * 楼栋总人数
     */
    @Column(name = "zrs", columnDefinition = "VARCHAR(64) COMMENT '楼栋总人数'")
    private String zrs;
    /**
     *  网格长
     */
    @Column(name = "wgz", columnDefinition = "VARCHAR(255) COMMENT '网格长'")
    private String wgz;
    /**
     *  网格管理员
     */
    @Column(name = "wggly", columnDefinition = "VARCHAR(255) COMMENT '网格管理员'")
    private String wggly;
    /**
     *  行业网格长
     */
    @Column(name = "hywgz", columnDefinition = "VARCHAR(255) COMMENT '行业网格长'")
    private String hywgz;
    /**
     *  行业网格成员
     */
    @Column(name = "hywgcy", columnDefinition = "VARCHAR(3000) COMMENT '行业网格成员'")
    private String hywgcy;
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
