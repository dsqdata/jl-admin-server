package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 严防外源输入- 防范境外疫情输入管控情况分析
 * @author DDXS
 * @date 2020/3/27 10:06
 */
@Data
@Entity
@Table(name = "yndp_five_enter_country")
public class YndpFiveEnterCountry extends YndpBaseUuidEntity {
    /**
     * 填报日期(yyyymmdd)
     */
    @Column(name = "date", columnDefinition = "VARCHAR(32) COMMENT '填报日期(yyyymmdd)'")
    private String date;
    /**
     * 14天内有疫情严重国家和地区旅居史的公民--总数
     */
    @Column(name = "num11", columnDefinition = "VARCHAR(32) COMMENT '14天内有疫情严重国家和地区旅居史的公民--总数'")
    private String num11;
    /**
     * 14天内有疫情严重国家和地区旅居史的公民--中国籍
     */
    @Column(name = "num12", columnDefinition = "VARCHAR(32) COMMENT '14天内有疫情严重国家和地区旅居史的公民--中国籍'")
    private String num12;
    /**
     * 14天内有疫情严重国家和地区旅居史的公民--外国籍
     */
    @Column(name = "num13", columnDefinition = "VARCHAR(32) COMMENT '14天内有疫情严重国家和地区旅居史的公民--外国籍'")
    private String num13;
    /**
     * 来自非疫情严重国家和地区人员--总数
     */
    @Column(name = "num21", columnDefinition = "VARCHAR(32) COMMENT '来自非疫情严重国家和地区人员--总数'")
    private String num21;
    /**
     * 来自非疫情严重国家和地区人员--中国籍
     */
    @Column(name = "num22", columnDefinition = "VARCHAR(32) COMMENT '来自非疫情严重国家和地区人员--中国籍'")
    private String num22;
    /**
     * 来自非疫情严重国家和地区人员--外国籍
     */
    @Column(name = "num23", columnDefinition = "VARCHAR(32) COMMENT '来自非疫情严重国家和地区人员--外国籍'")
    private String num23;
    /**
     * 昆明学院外籍留学生
     */
    @Column(name = "num", columnDefinition = "VARCHAR(32) COMMENT '昆明学院外籍留学生'")
    private String num;
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
