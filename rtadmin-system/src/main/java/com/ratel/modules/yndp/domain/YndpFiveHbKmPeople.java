package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 严防外源输入- 弹出层-国外人员信息
 * @author GXP
 * @date 2020/2/26 8:47
 */
@Data
@Entity
@Table(name = "yndp_five_alert_hubei_return_kuming_people")
public class YndpFiveHbKmPeople extends YndpBaseUuidEntity {

    /**
     * 序号（+排序）
     */
    @Column(name = "order_num", columnDefinition = "INT COMMENT '序号（+排序） '")
    private int order_num;
    /**
     * 姓名
     */
    @Column(name = "name", columnDefinition = "VARCHAR(32) COMMENT '姓名 '")
    private String name;
    /**
     * 性别
     */
    @Column(name = "sex", columnDefinition = "VARCHAR(100) COMMENT '性别 '")
    private String sex;

    /**
     * 入滇目的
     */
    @Column(name = "ext1", columnDefinition = "VARCHAR(100) COMMENT '入滇目的'")
    private String ext1;
    /**
     * 管理地点
     */
    @Column(name = "ext2", columnDefinition = "VARCHAR(100) COMMENT '管理地点'")
    private String ext2;
    /**
     * 核酸检测情况
     */
    @Column(name = "ext3", columnDefinition = "VARCHAR(100) COMMENT '核酸检测情况'")
    private String ext3;
    /**
     * 当前健康情况
     */
    @Column(name = "ext4", columnDefinition = "VARCHAR(100) COMMENT '当前健康情况'")
    private String ext4;
    /**
     * 当前状态
     */
    @Column(name = "ext5", columnDefinition = "VARCHAR(100) COMMENT '当前状态'")
    private String ext5;
    /**
     * 备注
     */
    @Column(name = "ext6", columnDefinition = "VARCHAR(100) COMMENT '备注'")
    private String ext6;
    /**
     * 创建时间
     */
    /*@Column(name = "create_time", columnDefinition = "VARCHAR(32) COMMENT '创建时间'")
    private String create_time;*/

}
