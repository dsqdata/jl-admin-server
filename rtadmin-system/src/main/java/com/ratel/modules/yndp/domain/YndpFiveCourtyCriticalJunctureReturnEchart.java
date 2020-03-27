package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 严防外源输入- 疫情严重国家-echart
 * @author DDXS
 * @date 2020/3/27 10:01
 */
@Data
@Entity
@Table(name = "yndp_five_courty_critical_juncture_return_echart")
public class YndpFiveCourtyCriticalJunctureReturnEchart extends YndpBaseUuidEntity {
    /**
     * 填报日期(yyyymmdd)
     */
    @Column(name = "date", columnDefinition = "VARCHAR(32) COMMENT '填报日期(yyyymmdd)'")
    private String date;
    /**
     * 国家名称
     */
    @Column(name = "name", columnDefinition = "VARCHAR(100) COMMENT '国家名称'")
    private String name;
    /**
     * 返回人数
     */
    @Column(name = "return_num", columnDefinition = "int COMMENT '返回人数'")
    private String return_num;

    /**
     * >=10000严重，<10000不严重
     */
    @Column(name = "num", columnDefinition = "int COMMENT ' >=10000严重，<10000不严重'")
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
