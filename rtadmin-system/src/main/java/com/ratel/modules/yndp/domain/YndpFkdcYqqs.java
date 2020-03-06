package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 防控洞察-疫情趋势表
 * @author zhaoweiming
 * @date 2020/2/26 10:10
 */
@Data
@Entity
@Table(name = "yndp_fkdc_yqqs")
public class YndpFkdcYqqs extends BaseUuidEntity {

    /**
     * 疫情名称
     */
    @Column(name = "yqmc", columnDefinition = "VARCHAR(64) COMMENT '疫情名称'")
    private String yqmc;
    /**
     * 疫情数量
     */
    @Column(name = "yqsl", columnDefinition = "VARCHAR(64) COMMENT '疫情数量'")
    private String yqsl;
    /**
     * 疫情类型(1新增确诊 2新增疑似 3现存确诊 4现存疑似 5死亡 6治愈 7病死率 8治愈率)
     */
    @Column(name = "yqlx", columnDefinition = "VARCHAR(64) COMMENT '疫情类型(1新增疑似 2新增确诊 3现存确诊 4现存疑似 5死亡 6治愈 7病死率 8治愈率)'")
    private String yqlx;
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

    /**
     * 显示多少日期数据(ALL查询所有，传数字显示数字个数的数据)
     */
    @Transient
    private String rowCount;
}
