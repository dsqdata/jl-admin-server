package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 防控洞察-地图展示表
 * @author DDXS
 * @date 2020/2/26 9:56
 */
@Data
@Entity
@Table(name = "yndp_fkdc_map")
public class YndpFkdcMap  extends BaseUuidEntity {

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
     * 确诊类型： 1：现存确诊，2:累计确诊
     */
    @Column(name = "qzlx", columnDefinition = "VARCHAR(64) COMMENT '确诊类型： 1：现存确诊，2:累计确诊'")
    private String qzlx;
    /**
     *  现存确诊数
     */
    @Column(name = "xcqzs", columnDefinition = "VARCHAR(64) COMMENT '现存确诊数'")
    private String xcqzs;
    /**
     *  累积确诊数
     */
    @Column(name = "ljqzs", columnDefinition = "VARCHAR(64) COMMENT '累积确诊数'")
    private String ljqzs;
    /**
     * 疫区来昆人数
     */
    @Column(name = "yqlkrs", columnDefinition = "VARCHAR(64) COMMENT '疫区来昆人数'")
    private String yqlkrs;
    /**
     *户数
     */
    @Column(name = "hs", columnDefinition = "VARCHAR(64) COMMENT '户数'")
    private String hs;
    /**
     *人数
     */
    @Column(name = "rs", columnDefinition = "VARCHAR(64) COMMENT '人数'")
    private String rs;
    /**
     * 疫情事件
     */
    @Column(name = "yqsj", columnDefinition = "VARCHAR(64) COMMENT '疫情事件'")
    private String yqsj;

    /**
     * 摄像头
     */
    @Column(name = "sxt", columnDefinition = "VARCHAR(64) COMMENT '摄像头'")
    private String sxt;

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
