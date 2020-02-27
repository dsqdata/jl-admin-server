package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseNativeEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 防控部署-网格表
 * @author DDXS
 * @date 2020/2/26 18:47
 */
@Data
@Entity
@Table(name = "yndp_fkbs_wg")
public class YndpFkbsWg extends BaseNativeEntity {
    /**
     * 机构ID
     */
    @Column(name = "jgid", columnDefinition = "VARCHAR(64) COMMENT '机构ID'")
    private String jgid;

    /**
     * 网格管理员
     */
    @Column(name = "wggly", columnDefinition = "VARCHAR(255) COMMENT '网格管理员'")
    private String wggly;
    /**
     * 社区网格管理员管辖小区个数
     */
    @Column(name = "xqnum", columnDefinition = "VARCHAR(64) COMMENT '社区网格管理员管辖小区个数'")
    private String xqnum;
    /**
     * 社区网格管理员管辖小区居民总户数
     */
    @Column(name = "jmzhs", columnDefinition = "VARCHAR(64) COMMENT '社区网格管理员管辖小区居民总户数'")
    private String jmzhs;
    /**
     * 社区网格管理员管辖小区居民总人数
     */
    @Column(name = "jmzrs", columnDefinition = "VARCHAR(64) COMMENT '社区网格管理员管辖小区居民总人数'")
    private String jmzrs;
    /**
     * 社区网格管理员管辖主干道条数
     */
    @Column(name = "zgdts", columnDefinition = "VARCHAR(64) COMMENT '社区网格管理员管辖主干道条数'")
    private String zgdts;
    /**
     * 社区网格管理员管辖背街小巷条数
     */
    @Column(name = "bjxxts", columnDefinition = "VARCHAR(64) COMMENT '社区网格管理员管辖背街小巷条数'")
    private String bjxxts;
    /**
     * 社区网格管理员管辖企事业单位个数
     */
    @Column(name = "qsydwgs", columnDefinition = "VARCHAR(64) COMMENT '社区网格管理员管辖企事业单位个数'")
    private String qsydwgs;
    /**
     *  行业网格长
     */
    @Column(name = "hywgz", columnDefinition = "VARCHAR(255) COMMENT '行业网格长'")
    private String hywgz;
    /**
     *  行业网格员
     */
    @Column(name = "hywgy", columnDefinition = "VARCHAR(255) COMMENT '行业网格员'")
    private String hywgy;
    /**
     *  行业公司个数
     */
    @Column(name = "gsgs", columnDefinition = "VARCHAR(64) COMMENT '行业领域公司个数'")
    private String gsgs;
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
