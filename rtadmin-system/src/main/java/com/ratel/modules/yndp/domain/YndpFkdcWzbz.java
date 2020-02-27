package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseNativeEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 防控洞察-物资保障表
 * @author DDXS
 * @date 2020/2/25 16:51
 */
@Data
@Entity
@Table(name = "yndp_fkdc_wzbz")
public class YndpFkdcWzbz extends BaseNativeEntity {

    /**
     * 日期
     */
    @Column(name = "rq", columnDefinition = "VARCHAR(20) COMMENT '日期'")
    private String rq;
    /**
     * 物资
     */
    @Column(name = "wz", columnDefinition = "VARCHAR(64) COMMENT '物资'")
    private String wz;
    /**
     * 入库
     */
    @Column(name = "rk", columnDefinition = "VARCHAR(64) COMMENT '入库'")
    private String rk;
    /**
     * 发出
     */
    @Column(name = "fc", columnDefinition = "VARCHAR(64) COMMENT '发出'")
    private String fc;
    /**
     * 结存
     */
    @Column(name = "jc", columnDefinition = "VARCHAR(64) COMMENT '结存'")
    private String jc;
    /**
     * 备注
     */
    @Column(name = "bz", columnDefinition = "VARCHAR(64) COMMENT '备注'")
    private String bz;
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
