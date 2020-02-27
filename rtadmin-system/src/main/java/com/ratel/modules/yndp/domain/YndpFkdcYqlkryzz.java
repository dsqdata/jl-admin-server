package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 防控洞察-疫区来昆人员追踪表
 * @author zhaoweiming
 * @date 2020/2/26 11:10
 */
@Data
@Entity
@Table(name = "yndp_fkdc_yqlkryzz")
public class YndpFkdcYqlkryzz extends BaseUuidEntity {

    /**
     * 人员类型(总数，已住店离观，离昆，隔离期过14天，不在辖区居住地，解除医学观察人员，入住指定的如家商旅酒店，湖北以外其他地方回昆人员，其他)
     */
    @Column(name = "rylx", columnDefinition = "VARCHAR(64) COMMENT '人员类型(总数，已住店离观，离昆，隔离期过14天，不在辖区居住地，解除医学观察人员，入住指定的如家商旅酒店，湖北以外其他地方回昆人员，其他)'")
    private String rylx;
    /**
     * 人员数量
     */
    @Column(name = "rysl", columnDefinition = "VARCHAR(64) COMMENT '人员数量'")
    private String rysl;
    /**
     * 排序
     */
    @Column(name = "px", columnDefinition = "VARCHAR(64) COMMENT '排序'")
    private String px;
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
