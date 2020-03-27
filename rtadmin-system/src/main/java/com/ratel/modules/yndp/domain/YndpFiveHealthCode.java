package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 严防外源输入-云南健康码系统推送人员排查
 * @author DDXS
 * @date 2020/3/27 10:28
 */
@Data
@Entity
@Table(name = "yndp_five_health_code")
public class YndpFiveHealthCode extends YndpBaseUuidEntity {
    /**
     * 填报日期(yyyymmdd)
     */
    @Column(name = "date", columnDefinition = "VARCHAR(32) COMMENT '填报日期(yyyymmdd)'")
    private String date;
    /**
     * 消息
     */
    @Column(name = "msg", columnDefinition = "VARCHAR(100) COMMENT '消息'")
    private String msg;
    /**
     * 当日红码
     */
    @Column(name = "num11", columnDefinition = "VARCHAR(32) COMMENT '当日红码'")
    private String num11;
    /**
     * 当日黄码
     */
    @Column(name = "num12", columnDefinition = "VARCHAR(32) COMMENT '当日黄码'")
    private String num12;
    /**
     * 当日状态
     */
    @Column(name = "status1", columnDefinition = "VARCHAR(32) COMMENT '当日状态'")
    private String status1;
    /**
     * 累计红码
     */
    @Column(name = "num21", columnDefinition = "VARCHAR(32) COMMENT '累计红码'")
    private String num21;
    /**
     * 累计黄码
     */
    @Column(name = "num22", columnDefinition = "VARCHAR(32) COMMENT '累计黄码'")
    private String num22;
    /**
     * 累计状态
     */
    @Column(name = "status2", columnDefinition = "VARCHAR(32) COMMENT '累计状态'")
    private String status2;
    /**
     * 预留1
     */
    @Column(name = "ext1", columnDefinition = "VARCHAR(32) COMMENT '预留1'")
    private String ext1;
    /**
     * 预留2
     */
    @Column(name = "ext2", columnDefinition = "VARCHAR(32) COMMENT '预留2'")
    private String ext2;
    /**
     * 预留3
     */
    @Column(name = "ext3", columnDefinition = "VARCHAR(32) COMMENT '预留3'")
    private String ext3;



}
