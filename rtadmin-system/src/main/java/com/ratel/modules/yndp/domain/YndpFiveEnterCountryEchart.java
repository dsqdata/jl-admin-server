package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *严防外源输入- 防范境外疫情输入管控情况分析-echart
 * @author DDXS
 * @date 2020/3/27 10:14
 */
@Data
@Entity
@Table(name = "yndp_five_enter_country_echart")
public class YndpFiveEnterCountryEchart extends YndpBaseUuidEntity {
    /**
     * 填报日期(yyyymmdd)
     */
    @Column(name = "date", columnDefinition = "VARCHAR(32) COMMENT '填报日期(yyyymmdd)'")
    private String date;
    /**
     * 14天内有疫情严重国家和地区旅居史的公民--总数
     */
    @Column(name = "num1", columnDefinition = "VARCHAR(32) COMMENT '14天内有疫情严重国家和地区旅居史的公民--总数'")
    private String num1;
    /**
     * 来自非疫情严重国家和地区人员--总数
     */
    @Column(name = "num2", columnDefinition = "VARCHAR(32) COMMENT '来自非疫情严重国家和地区人员--总数'")
    private String num2;
    /**
     * 昆明学院外籍留学生
     */
    @Column(name = "num3", columnDefinition = "VARCHAR(32) COMMENT '昆明学院外籍留学生'")
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
