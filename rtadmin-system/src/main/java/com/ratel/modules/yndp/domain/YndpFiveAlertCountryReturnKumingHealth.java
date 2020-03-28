package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 严防外源输入- 弹出层-境外入滇人员当前健康状态
 * @author GXP
 * @date 2020/2/26 8:47
 */
@Data
@Entity
@Table(name = "yndp_five_alert_country_return_kuming_health")
public class YndpFiveAlertCountryReturnKumingHealth extends YndpBaseUuidEntity {

    /**
     * 总人数
     */
    @Column(name = "num", columnDefinition = "INT COMMENT '总人数 '")
    private int num;
    /**
     * 异常人数
     */
    @Column(name = "num1", columnDefinition = "INT COMMENT '异常人数 '")
    private int num1;
    /**
     * 中国籍
     */
    @Column(name = "num2", columnDefinition = "INT COMMENT '中国籍 '")
    private int num2;
    /**
     * 外国籍
     */
    @Column(name = "num3", columnDefinition = "INT COMMENT '外国籍 '")
    private int num3;

    /**
     * 扩展1
     */
    @Column(name = "ext1", columnDefinition = "VARCHAR(32) COMMENT '扩展1'")
    private String ext1;
    /**
     * 扩展2
     */
    @Column(name = "ext2", columnDefinition = "VARCHAR(32) COMMENT '扩展2'")
    private String ext2;
    /**
     * 扩展3
     */
    @Column(name = "ext3", columnDefinition = "VARCHAR(32) COMMENT '扩展3'")
    private String ext3;
    /**
     * 创建时间
     */
    /*@Column(name = "create_time", columnDefinition = "VARCHAR(32) COMMENT '创建时间'")
    private String create_time;*/

}
