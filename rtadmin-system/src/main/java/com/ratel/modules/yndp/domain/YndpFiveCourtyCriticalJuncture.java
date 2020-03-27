package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 严防外源输入- 疫情严重国家
 * @author DDXS
 * @date 2020/3/27 10:01
 */
@Data
@Entity
@Table(name = "yndp_five_courty_critical_juncture")
public class YndpFiveCourtyCriticalJuncture extends YndpBaseUuidEntity {
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
     *
     */
    @Column(name = "num", columnDefinition = "VARCHAR(100) COMMENT ''")
    private String num;

}
