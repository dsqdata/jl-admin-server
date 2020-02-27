package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseNativeEntity;
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
public class YndpFkdcMap  extends BaseNativeEntity {

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



}
