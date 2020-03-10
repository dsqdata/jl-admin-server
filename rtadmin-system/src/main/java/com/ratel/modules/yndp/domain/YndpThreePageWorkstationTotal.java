package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 疫情工作动态-留验站工作动态
 * @author GXP
 * @date 2020/2/26 8:47
 */
@Data
@Entity
@Table(name = "yndp_three_page_workstation_total")
public class YndpThreePageWorkstationTotal extends YndpBaseUuidEntity {

    /**
     * 采集日期(yyyymmdd)
     */
    @Column(name = "date", columnDefinition = "VARCHAR(20) COMMENT '采集日期(yyyymmdd)'")
    private String date;
    /**
     * 留验站名称_id
     */
    @Column(name = "workstation_id", columnDefinition = "VARCHAR(20) COMMENT '留验站名称_id'")
    private String workstation_id;
    /**
     * 新增集中医学观察人数
     */
    @Column(name = "today_count", columnDefinition = "VARCHAR(20) COMMENT '新增集中医学观察人数'")
    private String today_count;
    /**
     * 累计集中医学观察人数
     */
    @Column(name = "all_count", columnDefinition = "VARCHAR(20) COMMENT '累计集中医学观察人数'")
    private String all_count;
    /**
     * 累计解除隔离人数
     */
    @Column(name = "all_remove", columnDefinition = "VARCHAR(20) COMMENT '累计解除隔离人数'")
    private String all_remove;

    /**
     * 新增解除隔离人数
     */
    @Column(name = "tody_remove", columnDefinition = "VARCHAR(20) COMMENT '新增解除隔离人数'")
    private String tody_remove;
    /**
     * 解除隔离湖北籍人数
     */
    @Column(name = "hubei_remove", columnDefinition = "VARCHAR(20) COMMENT '解除隔离湖北籍人数'")
    private String hubei_remove;
    /**
     * 解除隔离湖北籍去如家酒店人数
     */
    @Column(name = "hubei_remove_rujia", columnDefinition = "VARCHAR(20) COMMENT '解除隔离湖北籍去如家酒店人数'")
    private String hubei_remove_rujia;
    /**
     * 解除隔离湖北籍去经开区固定住所人数
     */
    @Column(name = "hubei_remove_home", columnDefinition = "VARCHAR(20) COMMENT '解除隔离湖北籍去经开区固定住所人数'")
    private String hubei_remove_home;
    /**
     * 解除隔离湖北籍其他去向人数
     */
    @Column(name = "hubei_remove_other", columnDefinition = "VARCHAR(20) COMMENT '解除隔离湖北籍其他去向人数'")
    private String hubei_remove_other;
    /**
     * 解除隔离非湖北籍人数
     */
    @Column(name = "other_remove", columnDefinition = "VARCHAR(20) COMMENT '解除隔离非湖北籍人数'")
    private String other_remove;
    /**
     * 解除隔离云南籍人数
     */
    @Column(name = "other_yunan_remove", columnDefinition = "VARCHAR(20) COMMENT '解除隔离云南籍人数'")
    private String other_yunan_remove;
    /**
     * 解除隔离其他省市籍人数
     */
    @Column(name = "other_other_remove", columnDefinition = "VARCHAR(20) COMMENT '解除隔离其他省市籍人数'")
    private String other_other_remove;
    /**
     * 实有入住留验人数
     */
    @Column(name = "all_checkin", columnDefinition = "VARCHAR(20) COMMENT '实有入住留验人数'")
    private String all_checkin;
    /**
     * 新增入住留验人数
     */
    @Column(name = "toady_checkin", columnDefinition = "VARCHAR(20) COMMENT '新增入住留验人数'")
    private String toady_checkin;
    /**
     * 湖北籍入住留验人数
     */
    @Column(name = "hubei_checkin", columnDefinition = "VARCHAR(20) COMMENT '湖北籍入住留验人数'")
    private String hubei_checkin;
    /**
     * 非湖北籍入住留验人数
     */
    @Column(name = "other_checkin", columnDefinition = "VARCHAR(20) COMMENT '非湖北籍入住留验人数'")
    private String other_checkin;

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
