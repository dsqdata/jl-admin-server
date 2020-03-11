package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 疫情工作动态-社区/村人员核查和信息采集
 * @author GXP
 * @date 2020/2/26 8:47
 */
@Data
@Entity
@Table(name = "yndp_three_page_collection_echart")
public class YndpThreePageCollectionEchart extends YndpBaseUuidEntity {

    /**
     * 采集日期(yyyymmdd)
     */
    @Column(name = "date", columnDefinition = "VARCHAR(20) COMMENT '采集日期(yyyymmdd)'")
    private String date;
    /**
     * 基础要素采集APP累计安装量
     */
    @Column(name = "ext1", columnDefinition = "VARCHAR(20) COMMENT '基础要素采集APP累计安装量'")
    private String ext1;
    /**
     * 社区信息APP使用量
     */
    @Column(name = "ext2", columnDefinition = "VARCHAR(20) COMMENT '社区信息APP使用量'")
    private String ext2;
    /**
     * 核查实有人口数
     */
    @Column(name = "ext3", columnDefinition = "VARCHAR(20) COMMENT '核查实有人口数'")
    private String ext3;
    /**
     * 核查从业人员数量
     */
    @Column(name = "ext4", columnDefinition = "VARCHAR(20) COMMENT '核查从业人员数量'")
    private String ext4;

    /**
     * 扩展1
     */
    @Column(name = "ext5", columnDefinition = "VARCHAR(20) COMMENT '扩展1'")
    private String ext5;
    /**
     * 扩展2
     */
    @Column(name = "ext6", columnDefinition = "VARCHAR(20) COMMENT '扩展2'")
    private String ext6;
    /**
     * 扩展3
     */
    @Column(name = "ext7", columnDefinition = "VARCHAR(20) COMMENT '扩展3'")
    private String ext7;
    /**
     * 创建时间
     */
    /*@Column(name = "create_time", columnDefinition = "datetime) COMMENT '创建时间'")
    private Date create_time;*/

}
