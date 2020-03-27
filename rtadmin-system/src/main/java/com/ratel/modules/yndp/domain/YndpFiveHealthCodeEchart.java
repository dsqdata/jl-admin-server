package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 严防外源输入-云南健康码系统推送人员排查-echart
 * @author DDXS
 * @date 2020/3/27 10:33
 */
@Data
@Entity
@Table(name = "yndp_five_health_code_echart")
public class YndpFiveHealthCodeEchart extends YndpBaseUuidEntity {
    /**
     * 填报日期(yyyymmdd)
     */
    @Column(name = "date", columnDefinition = "VARCHAR(32) COMMENT '填报日期(yyyymmdd)'")
    private String date;
    /**
     * 当日红码
     */
    @Column(name = "num1", columnDefinition = "VARCHAR(32) COMMENT '当日红码'")
    private String num1;
    /**
     * 当日黄码
     */
    @Column(name = "num2", columnDefinition = "VARCHAR(32) COMMENT '当日黄码'")
    private String num2;
    /**
     * 累计推送
     */
    @Column(name = "num3", columnDefinition = "VARCHAR(32) COMMENT '累计推送'")
    private String num3;
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
