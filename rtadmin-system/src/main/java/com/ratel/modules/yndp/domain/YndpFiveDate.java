package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 严防外源输入-数据更新时间
 * @author DDXS
 * @date 2020/3/27 9:57
 */
@Data
@Entity
@Table(name = "yndp_five_date")
public class YndpFiveDate extends YndpBaseUuidEntity {
    /**
     * 数据更新时间(yyyymmdd)
     */
    @Column(name = "date", columnDefinition = "VARCHAR(32) COMMENT '数据更新时间(yyyymmdd)'")
    private String date;

}
