package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseNativeEntity;
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
public class YndpFkdcWghpcLflk extends BaseNativeEntity {

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

}
