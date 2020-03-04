package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseUuidEntity;
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
public class YndpFkbsWgcy extends BaseUuidEntity {

    /**
     * 网格ID
     */
    @Column(name = "wgid", columnDefinition = "VARCHAR(64) COMMENT '网格ID'")
    private String wgid;
    /**
     * 网格名称
     */
    @Column(name = "wgmc", columnDefinition = "VARCHAR(64) COMMENT '网格名称'")
    private String wgmc;
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
     * 楼栋数
     */
    @Column(name = "lds", columnDefinition = "VARCHAR(64) COMMENT '楼栋数'")
    private String lds;

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
     *  机构网格长
     */
    @Column(name = "jgwgz", columnDefinition = "VARCHAR(255) COMMENT '机构网格长'")
    private String jgwgz;
    /**
     *  机构网格管理员
     */
    @Column(name = "jgwggly", columnDefinition = "VARCHAR(255) COMMENT '机构网格管理员'")
    private String jgwggly;
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
     *  党员代表
     */
    @Column(name = "dydb", columnDefinition = "VARCHAR(3000) COMMENT '党员代表'")
    private String dydb;
    /**
     *  联系电话
     */
    @Column(name = "lxdh", columnDefinition = "VARCHAR(3000) COMMENT '联系电话'")
    private String lxdh;
    /**
     *  联系户数
     */
    @Column(name = "lxhs", columnDefinition = "VARCHAR(3000) COMMENT '联系户数'")
    private String lxhs;
    /**
     * 排序
     */
    @Column(name = "px", columnDefinition = "VARCHAR(64) COMMENT '排序'")
    private String px;
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
