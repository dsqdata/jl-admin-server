package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 防控洞察-网格化排查及联防联控表
 * @author DDXS
 * @date 2020/2/26 8:47
 */
@Data
@Entity
@Table(name = "yndp_fkdc_wghpclflk")
public class YndpFkdcWghpcLflk extends BaseUuidEntity {

    /**
     * 发动参加排查人员总数-累计
     */
    @Column(name = "fdcjpcryzslj", columnDefinition = "VARCHAR(64) COMMENT '发动参加排查人员总数-累计'")
    private String fdcjpcryzslj;
    /**
     * 发动参加排查人员总数-新增
     */
    @Column(name = "fdcjpcryzsxz", columnDefinition = "VARCHAR(64) COMMENT '发动参加排查人员总数-新增'")
    private String fdcjpcryzsxz;
    /**
     * 微信群数量-累计
     */
    @Column(name = "wxqsllj", columnDefinition = "VARCHAR(64) COMMENT '微信群数量-累计'")
    private String wxqsllj;
    /**
     * 微信群数量-新增
     */
    @Column(name = "wxqslxz", columnDefinition = "VARCHAR(64) COMMENT '微信群数量-新增'")
    private String wxqslxz;
    /**
     * 排查总人数-累计
     */
    @Column(name = "pczrslj", columnDefinition = "VARCHAR(64) COMMENT '排查总人数-累计'")
    private String pczrslj;
    /**
     * 排查总人数-新增
     */
    @Column(name = "pczrsxz", columnDefinition = "VARCHAR(64) COMMENT '排查总人数-新增'")
    private String pczrsxz;
    /**
     * 微信群覆盖率-累计
     */
    @Column(name = "fxqfgllj", columnDefinition = "VARCHAR(64) COMMENT '微信群覆盖率-累计'")
    private String fxqfgllj;
    /**
     * 微信群覆盖率-新增
     */
    @Column(name = "fxqfglxz", columnDefinition = "VARCHAR(64) COMMENT '微信群覆盖率-新增'")
    private String fxqfglxz;
    /**
     * 类型：1:区级，2：街道级，3：社区级别
     */
    @Column(name = "type", columnDefinition = "VARCHAR(2) COMMENT '类型：1:区级，2：街道级，3：社区级别'")
    private String type;
    /**
     * 机构ID
     */
    @Column(name = "jgid", columnDefinition = "VARCHAR(64) COMMENT '机构ID'")
    private String jgid;
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
