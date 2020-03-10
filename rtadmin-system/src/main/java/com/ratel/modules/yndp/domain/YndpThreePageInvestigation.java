package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 疫情工作动态-固定检查点排查
 * @author GXP
 * @date 2020/2/26 8:47
 */
@Data
@Entity
@Table(name = "yndp_three_page_investigation")
public class YndpThreePageInvestigation extends YndpBaseUuidEntity {

    /**
     * 采集日期(yyyymmdd)
     */
    @Column(name = "date", columnDefinition = "VARCHAR(20) COMMENT '采集日期(yyyymmdd)'")
    private String date;
    /**
     * 固定检查点个数
     */
    @Column(name = "count", columnDefinition = "VARCHAR(20) COMMENT '固定检查点个数'")
    private String count;
    /**
     * 当日排查人数
     */
    @Column(name = "today_person", columnDefinition = "VARCHAR(20) COMMENT '当日排查人数'")
    private String today_person;
    /**
     * 累计排查人数
     */
    @Column(name = "all_persons", columnDefinition = "VARCHAR(20) COMMENT '累计排查人数'")
    private String all_persons;
    /**
     * 当日排查车辆数
     */
    @Column(name = "today_vehicle", columnDefinition = "VARCHAR(20) COMMENT '当日排查车辆数'")
    private String today_vehicle;
    /**
     * 累计排查车辆数
     */
    @Column(name = "all_vehicle", columnDefinition = "VARCHAR(20) COMMENT '累计排查车辆数'")
    private String all_vehicle;
    /**
     * 扩展1
     */
    @Column(name = "ext1", columnDefinition = "VARCHAR(20) COMMENT '扩展1'")
    private String ext1;
    /**
     * 扩展2
     */
    @Column(name = "ext2", columnDefinition = "VARCHAR(20) COMMENT '扩展2'")
    private String ext2;
    /**
     * 扩展3
     */
    @Column(name = "ext3", columnDefinition = "VARCHAR(20) COMMENT '扩展3'")
    private String ext3;
    /**
     * 创建时间
     */
    /*@Column(name = "create_time", columnDefinition = "datetime) COMMENT '创建时间'")
    private Date create_time;*/

}
