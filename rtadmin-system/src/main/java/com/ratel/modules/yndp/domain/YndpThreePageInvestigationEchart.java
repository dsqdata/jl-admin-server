package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 *
 * 固定检查点排查-echart 图
 * @author xujinliang
 * @date 2020/3/9 10:10
 */
@Data
@Entity
@Table(name = "yndp_three_page_investigation_echart")
public class YndpThreePageInvestigationEchart extends YndpBaseUuidEntity {

    /**
     * 填报日期（yyyymmdd）
     */
    @Column(name = "date", columnDefinition = "VARCHAR(20) COMMENT '填报日期（yyyymmdd）'")
    private String date;
    /*
     * 剩余固定检查点
     */
    @Column(name = "ext1", columnDefinition = "VARCHAR(20) COMMENT '剩余固定检查点 '")
    private String ext1;

    /**
     * 当期日排查人员
     */
    @Column(name = "ext2", columnDefinition = "VARCHAR(20) COMMENT '当期日排查人员 '")
    private String ext2;

    /**
     * 累计排查人员
     */
    @Column(name = "ext3", columnDefinition = "VARCHAR(20) COMMENT '累计排查人员'")
    private String ext3;

    /**
     * 当日排查车辆
     */
    @Column(name = "ext4", columnDefinition = "VARCHAR(20) COMMENT '当日排查车辆 '")
    private String ext4;

    /**
     * 累计排查车辆
     */
    @Column(name = "ext5", columnDefinition = "VARCHAR(20) COMMENT '累计排查车辆 '")
    private String ext5;

    /**
     * 扩展6
     */
    @Column(name = "ext6", columnDefinition = "VARCHAR(20) COMMENT ''")
    private String ext6;

    /**
     * 扩展7
     */
    @Column(name = "ext7", columnDefinition = "VARCHAR(20) COMMENT ''")
    private String ext7;

    /**
     * 扩展8
     */
    @Column(name = "ext8", columnDefinition = "VARCHAR(20) COMMENT ''")
    private String ext8;

    /**
     * 创建日期
     */
    @Column(name = "create_time", columnDefinition = "VARCHAR(20) COMMENT '创建日期'")
    private Date create_time;


}
