package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * 学校复学情况
 * @author xujinliang
 * @date 2020/3/9 10:10
 */
@Data
@Entity
@Table(name = "yndp_three_page_school")
public class YndpThreePageSchool extends YndpBaseUuidEntity {

    /**
     * 填报日期（yyyymmdd）
     */
    @Column(name = "date", columnDefinition = "VARCHAR(20) COMMENT '填报日期（yyyymmdd）'")
    private String date;
    /**
     * 各学校开学状态
     */
    @Column(name = "school", columnDefinition = "VARCHAR(20) COMMENT '各学校开学状态 '")
    private String school;
    /**
     * 幼儿园开学状态
     */
    @Column(name = "kindergarten ", columnDefinition = "VARCHAR(20) COMMENT '幼儿园开学状态'")
    private String kindergarten ;
    /**
     * 培训机构开学状态
     */
    @Column(name = "training", columnDefinition = "VARCHAR(20) COMMENT '培训机构开学状态'")
    private String training;

    /**
     * 创建日期
     */
    @Column(name = "create_time", columnDefinition = "VARCHAR(20) COMMENT '创建日期'")
    private Date create_time;


}
