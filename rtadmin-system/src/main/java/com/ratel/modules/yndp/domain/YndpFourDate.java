package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 校园疫情防控-数据更新时间
 * @author GXP
 * @date 2020/2/26 8:47
 */
@Data
@Entity
@Table(name = "yndp_four_date")
public class YndpFourDate extends YndpBaseUuidEntity {

    /**
     * 数据更新时间(yyyymmdd)
     */
    @Column(name = "date", columnDefinition = "VARCHAR(32) COMMENT '数据更新时间(yyyymmdd)'")
    private String date;

    /**
     * 创建时间
     */
    /*@Column(name = "create_time", columnDefinition = "datetime COMMENT '创建时间'")
    private Date create_time;*/

}
