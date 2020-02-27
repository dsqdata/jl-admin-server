package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 防控洞察-防控宣传表
 * @author DDXS
 * @date 2020/2/25 17:10
 */
@Data
@Entity
@Table(name = "yndp_fkdc_fkxc")
public class YndpFkdcFkxc extends BaseUuidEntity {

    /**
     * 发放宣传资料
     */
    @Column(name = "ffxczl", columnDefinition = "VARCHAR(64) COMMENT '发放宣传资料'")
    private String ffxczl;
    /**
     * 发放宣传资料（较昨日）
     */
    @Column(name = "ffxczljzr", columnDefinition = "VARCHAR(64) COMMENT '发放宣传资料(较昨日)'")
    private String ffxczljzr;
    /**
     * 微信群宣传
     */
    @Column(name = "wxqxc", columnDefinition = "VARCHAR(64) COMMENT '微信群宣传'")
    private String wxqxc;
    /**
     * 微信群宣传（较昨日）
     */
    @Column(name = "wxqxcjzr", columnDefinition = "VARCHAR(64) COMMENT '微信群宣传(较昨日)'")
    private String wxqxcjzr;
    /**
     * LED宣传
     */
    @Column(name = "ledxc", columnDefinition = "VARCHAR(64) COMMENT 'LED宣传'")
    private String lecxc;
    /**
     * LED宣传(较昨日)
     */
    @Column(name = "ledxcjzr", columnDefinition = "VARCHAR(64) COMMENT 'LED宣传(较昨日)'")
    private String lecxcjzr;
    /**
     * 发送短信
     */
    @Column(name = "fsdx", columnDefinition = "VARCHAR(64) COMMENT '发送短信'")
    private String fsdx;
    /**
     * 发送短信(较昨日)
     */
    @Column(name = "fsdxjzr", columnDefinition = "VARCHAR(64) COMMENT '发送短信(较昨日)'")
    private String fsdxjzr;
    /**
     * 其他
     */
    @Column(name = "qt", columnDefinition = "VARCHAR(64) COMMENT '其他'")
    private String qt;
    /**
     * 其他
     */
    @Column(name = "qtjzr", columnDefinition = "VARCHAR(64) COMMENT '其他(较昨日)'")
    private String qtjzr;
    /**
     * 受众人次
     */
    @Column(name = "szrc", columnDefinition = "VARCHAR(64) COMMENT '受众人次'")
    private String szrc;
    /**
     * 受众人次(较昨日)
     */
    @Column(name = "szrcjzr", columnDefinition = "VARCHAR(64) COMMENT '受众人次(较昨日)'")
    private String szrcjzr;
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
