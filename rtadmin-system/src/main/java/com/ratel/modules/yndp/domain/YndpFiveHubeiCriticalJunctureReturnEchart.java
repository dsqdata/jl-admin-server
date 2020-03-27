package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 严防外源输入- 湖北返回情况-echart
 * @author DDXS
 * @date 2020/3/27 10:42
 */
@Data
@Entity
@Table(name = "yndp_five_hubei_critical_juncture_return_echart")
public class YndpFiveHubeiCriticalJunctureReturnEchart extends YndpBaseUuidEntity {
    /**
     * 填报日期(yyyymmdd)
     */
    @Column(name = "date", columnDefinition = "VARCHAR(32) COMMENT '填报日期(yyyymmdd)'")
    private String date;
    /**
     * 返回人数
     */
    @Column(name = "return_num", columnDefinition = "int COMMENT '返回人数 '")
    private String return_num;
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
