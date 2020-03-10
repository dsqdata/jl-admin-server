package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 疫情工作动态-紧缺物资
 * @author GXP
 * @date 2020/2/26 8:47
 */
@Data
@Entity
@Table(name = "yndp_three_page_lack")
public class YndpThreePageLack extends YndpBaseUuidEntity {

    /**
     * 日期(yyyymmdd)
     */
    @Column(name = "date", columnDefinition = "VARCHAR(20) COMMENT '日期(yyyymmdd)'")
    private String date;
    /**
     * 物资名称
     */
    @Column(name = "name", columnDefinition = "VARCHAR(32) COMMENT '物资名称'")
    private String name;
    /**
     * 物资状态
     */
    @Column(name = "status", columnDefinition = "VARCHAR(32) COMMENT '物资状态'")
    private String status;
    /**
     * 级别
     */
    @Column(name = "rank", columnDefinition = "INT COMMENT '级别'")
    private String rank;


    /**
     * 创建时间
     */
    /*@Column(name = "create_time", columnDefinition = "datetime) COMMENT '创建时间'")
    private Date create_time;*/

}
