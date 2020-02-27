package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 防控部署-机构表
 * @author DDXS
 * @date 2020/2/26 18:47
 */
@Data
@Entity
@Table(name = "yndp_fkbs_jg")
public class YndpFkbsJg extends BaseUuidEntity {

    /**
     * 父ID
     */
    @Column(name = "parentid", columnDefinition = "VARCHAR(64) COMMENT '父ID'")
    private String parentid;

    /**
     * 机构名称
     */
    @Column(name = "jgmc", columnDefinition = "VARCHAR(64) COMMENT '机构名称'")
    private String jgmc;
    /**
     * 机构类型，0:区，1：街道/行业，2：社区/片区行业
     */
    @Column(name = "jglx", columnDefinition = "VARCHAR(2) COMMENT '机构类型，0:区，1：街道/行业，2：社区/片区行业'")
    private String jglx;

    /**
     * 机构或者行业, 1:机构，2:行业
     */
    @Column(name = "jgOrHy", columnDefinition = "VARCHAR(2) COMMENT '机构或者行业, 1:机构，2:行业'")
    private String jgOrHy;

    /**
     * 下级类型,1:小区，2：村，3：行业
     */
    @Column(name = "xjlx", columnDefinition = "VARCHAR(2) COMMENT '下级类型,1:小区，2：村，3：行业'")
    private String xjlxe;

    /**
     *   区疫情防控指挥部指挥长
     */
    @Column(name = "zhbzhz", columnDefinition = "VARCHAR(255) COMMENT '区疫情防控指挥部指挥长'")
    private String zhbzhz;
    /**
     *   区疫情防控指挥部副指挥长
     */
    @Column(name = "zhbfzhz", columnDefinition = "VARCHAR(255) COMMENT '区疫情防控指挥部副指挥长'")
    private String zhbfzhz;
    /**
     * 网格长
     */
    @Column(name = "wgz", columnDefinition = "VARCHAR(255) COMMENT '网格长'")
    private String wgz;

    /**
     * 包保领导
     */
    @Column(name = "bbld", columnDefinition = "VARCHAR(255) COMMENT '包保领导'")
    private String bbld;
    /**
     * 区级联系部门
     */
    @Column(name = "qjlxbm", columnDefinition = "VARCHAR(64) COMMENT '区级联系部门'")
    private String qjlxbm;
    /**
     * 街道网格长
     */
    @Column(name = "jdwgz", columnDefinition = "VARCHAR(255) COMMENT '街道网格长'")
    private String jdwgz;
    /**
     * 街道网格管理员
     */
    @Column(name = "jdwggly", columnDefinition = "VARCHAR(255) COMMENT '街道网格管理员'")
    private String jdwggly;
    /**
     * 社区网格长
     */
    @Column(name = "sqwgz", columnDefinition = "VARCHAR(255) COMMENT '社区网格长'")
    private String sqwgz;
    /**
     * 社区网格管理员
     */
    @Column(name = "sqwggly", columnDefinition = "VARCHAR(255) COMMENT '社区网格管理员'")
    private String sqwggly;
    /**
     * 区级网格长
     */
    @Column(name = "qjwgz", columnDefinition = "VARCHAR(255) COMMENT '区级网格长'")
    private String qjwgz;
    /**
     * 区级网格员
     */
    @Column(name = "qjwgy", columnDefinition = "VARCHAR(255) COMMENT '区级网格员'")
    private String qjwgy;

    /**
     * 经度
     */
    @Column(name = "jd", columnDefinition = "VARCHAR(255) COMMENT '经度'")
    private String jd;
    /**
     * 纬度
     */
    @Column(name = "wd", columnDefinition = "VARCHAR(255) COMMENT '纬度'")
    private String wd;

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
