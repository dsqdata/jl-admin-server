package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseNativeEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 防控洞察-疫情新增趋势表
 * @author zhaoweiming
 * @date 2020/2/26 10:10
 */
@Data
@Entity
@Table(name = "yndp_fkdc_yqxzqs")
public class YndpFkdcYqxzqs extends BaseNativeEntity {

    /**
     * 新增确诊
     */
    @Column(name = "xzqz", columnDefinition = "VARCHAR(64) COMMENT '新增确诊'")
    private String xzqz;
    /**
     * 新增疑似
     */
    @Column(name = "xzys", columnDefinition = "VARCHAR(64) COMMENT '新增疑似'")
    private String xzys;
    /**
     * 现存确诊
     */
    @Column(name = "xcqz", columnDefinition = "VARCHAR(64) COMMENT '现存确诊'")
    private String xcqz;
    /**
     * 现存疑似
     */
    @Column(name = "xcys", columnDefinition = "VARCHAR(64) COMMENT '现存疑似'")
    private String xcys;
    /**
     * 死亡
     */
    @Column(name = "sw", columnDefinition = "VARCHAR(64) COMMENT '死亡'")
    private String sw;
    /**
     * 治愈
     */
    @Column(name = "zy", columnDefinition = "VARCHAR(64) COMMENT '治愈'")
    private String zy;
    /**
     * 病死率
     */
    @Column(name = "bsl", columnDefinition = "VARCHAR(64) COMMENT '病死率'")
    private String bsl;
    /**
     * 治愈率
     */
    @Column(name = "zyl", columnDefinition = "VARCHAR(64) COMMENT '治愈率'")
    private String zyl;
    /**
     * 日期
     */
    @Column(name = "rq", columnDefinition = "VARCHAR(20) COMMENT '日期'")
    private String rq;
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
