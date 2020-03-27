package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 严防外源输入-湖北入昆人员-echart
 * @author DDXS
 * @date 2020/3/27 10:49
 */
@Data
@Entity
@Table(name = "yndp_five_hubei_people_echart")
public class YndpFiveHubeiPeopleEchart extends YndpBaseUuidEntity {
    /**
     * 填报日期(yyyymmdd)
     */
    @Column(name = "date", columnDefinition = "VARCHAR(32) COMMENT '填报日期(yyyymmdd)'")
    private String date;
    /**
     * 已核查
     */
    @Column(name = "num1", columnDefinition = "VARCHAR(32) COMMENT '已核查'")
    private String num1;
    /**
     * 核查中
     */
    @Column(name = "num2", columnDefinition = "VARCHAR(32) COMMENT '核查中'")
    private String num2;
    /**
     * 累计核查
     */
    @Column(name = "num3", columnDefinition = "VARCHAR(32) COMMENT '累计核查'")
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
