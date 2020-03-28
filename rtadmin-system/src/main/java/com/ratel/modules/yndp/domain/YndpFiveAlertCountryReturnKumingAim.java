package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 严防外源输入- 弹出层-境外入滇人员来源地国家分布
 * @author GXP
 * @date 2020/2/26 8:47
 */
@Data
@Entity
@Table(name = "yndp_five_alert_country_return_kuming_aim")
public class YndpFiveAlertCountryReturnKumingAim extends YndpBaseUuidEntity {

    /**
     * 分类名称
     */
    @Column(name = "type_name", columnDefinition = "VARCHAR(32) COMMENT '分类名称 '")
    private String type_name;
    /**
     * 分类值
     */
    @Column(name = "type_value", columnDefinition = "INT COMMENT '分类值 '")
    private int type_value;

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