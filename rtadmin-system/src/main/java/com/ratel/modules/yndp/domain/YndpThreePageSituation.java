package com.ratel.modules.yndp.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ratel.framework.core.domain.BaseUuidEntity;
import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 *  第三屏：当日疫情动态
 * @author DDXS
 * @date 2020/3/9 13:59
 */
@Data
@Entity
@Table(name = "yndp_three_page_situation")
public class YndpThreePageSituation extends YndpBaseUuidEntity {
    /**
     * 填报日期(yyyymmdd)
     */
    @Column(name = "date", columnDefinition = "VARCHAR(32) COMMENT '填报日期(yyyymmdd)'")
    private String date;
    /**
     * 当日确诊病例数
     */
    @Column(name = "today_confirmed", columnDefinition = "VARCHAR(20) COMMENT '当日确诊病例数'")
    private String today_confirmed;
    /**
     * 累计确诊病例数
     */
    @Column(name = "all_confirmed", columnDefinition = "VARCHAR(20) COMMENT '累计确诊病例数'")
    private String all_confirmed;
    /**
     * 当日疑似病例数
     */
    @Column(name = "today_suspected", columnDefinition = "VARCHAR(20) COMMENT '当日疑似病例数'")
    private String today_suspected;
    /**
     * 累计疑似病例数
     */
    @Column(name = "all_suspected", columnDefinition = "VARCHAR(20) COMMENT '累计疑似病例数'")
    private String all_suspected;
    /**
     * 当日密切接触者
     */
    @Column(name = "today_dlose", columnDefinition = "VARCHAR(20) COMMENT '当日密切接触者'")
    private String today_dlose;
    /**
     * 累计密切接触者
     */
    @Column(name = "all_close", columnDefinition = "VARCHAR(20) COMMENT '累计密切接触者'")
    private String all_close;
    /**
     * 解除人数
     */
    @Column(name = "relieve", columnDefinition = "VARCHAR(20) COMMENT '解除人数'")
    private String relieve;
    /**
     * 留验站集中医学观察人数
     */
    @Column(name = "observation", columnDefinition = "VARCHAR(20) COMMENT '留验站集中医学观察人数'")
    private String observation;
    /**
     * 观察人员健康状况
     */
    @Column(name = "observation_status", columnDefinition = "VARCHAR(20) COMMENT '观察人员健康状况'")
    private String observation_status;
    /**
     * 今日发热门诊接诊人次
     */
    @Column(name = "today_receive", columnDefinition = "VARCHAR(20) COMMENT '今日发热门诊接诊人次'")
    private String today_receive;
    /**
     * 发热门诊复诊人次
     */
    @Column(name = "today_further", columnDefinition = "VARCHAR(20) COMMENT '发热门诊复诊人次'")
    private String today_further;
    /**
     * 隔离观察治疗人数
     */
    @Column(name = "today_quarantine", columnDefinition = "VARCHAR(20) COMMENT '隔离观察治疗人数'")
    private String today_quarantine;
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
    @Column(name = "create_time", columnDefinition = "VARCHAR(20) COMMENT ' 创建时间'")
    private Date create_time;

    /**
     * 扩展4
     */
    @Column(name = "ext4", columnDefinition = "VARCHAR(20) COMMENT '扩展4'")
    private String ext4;

    /**
     * 扩展5
     */
    @Column(name = "ext5", columnDefinition = "VARCHAR(20) COMMENT '扩展5'")
    private String ext5;

    /**
     * 扩展6
     */
    @Column(name = "ext6", columnDefinition = "VARCHAR(20) COMMENT '扩展6'")
    private String ext6;

    /**
     * 扩展7
     */
    @Column(name = "ext7", columnDefinition = "VARCHAR(20) COMMENT '扩展7'")
    private String ext7;

    /**
     * 扩展8
     */
    @Column(name = "ext8", columnDefinition = "VARCHAR(20) COMMENT '扩展8'")
    private String ext8;

    /**
     * 扩展9
     */
    @Column(name = "ext9", columnDefinition = "VARCHAR(20) COMMENT '扩展9'")
    private String ext9;

    /**
     * 扩展10
     */
    @Column(name = "ext10", columnDefinition = "VARCHAR(20) COMMENT '扩展10'")
    private String ext10;

    /**
     * 扩展11
     */
    @Column(name = "ext11", columnDefinition = "VARCHAR(20) COMMENT '扩展11'")
    private String ext11;

    /**
     * 扩展12
     */
    @Column(name = "ext12", columnDefinition = "VARCHAR(20) COMMENT '扩展12'")
    private String ext12;

    @Override
    public String getId() {
        return null;
    }
}
