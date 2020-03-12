package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 疫情工作动态-社企业复工复产Echart
 * @author GXP
 * @date 2020/2/26 8:47
 */
@Data
@Entity
@Table(name = "yndp_three_page_rework_echart")
public class YndpThreePageReworkEchart extends YndpBaseUuidEntity {

    /**
     * 填报日期(yyyymmdd)
     */
    @Column(name = "date", columnDefinition = "VARCHAR(20) COMMENT '填报日期(yyyymmdd)'")
    private String date;
    /**
     * 累计复工
     */
    @Column(name = "ext1", columnDefinition = "VARCHAR(20) COMMENT '累计复工'")
    private String ext1;
    /**
     * 今日复工
     */
    @Column(name = "ext2", columnDefinition = "VARCHAR(20) COMMENT '今日复工'")
    private String ext2;
    /**
     * 复工率
     */
    @Column(name = "ext3", columnDefinition = "VARCHAR(20) COMMENT '复工率'")
    private String ext3;
    /**
     * 规模以上工业复工
     */
    @Column(name = "ext4", columnDefinition = "VARCHAR(20) COMMENT '规模以上工业复工'")
    private String ext4;

    /**
     * 限额以上商贸业复工
     */
    @Column(name = "ext5", columnDefinition = "VARCHAR(20) COMMENT '限额以上商贸业复工'")
    private String ext5;
    /**
     * 房地产企业复工
     */
    @Column(name = "ext6", columnDefinition = "VARCHAR(20) COMMENT '房地产企业复工'")
    private String ext6;
    /**
     * 资质以上建筑业复工
     */
    @Column(name = "ext7", columnDefinition = "VARCHAR(20) COMMENT '资质以上建筑业复工'")
    private String ext7;
    /**
     * 扩展1
     */
    @Column(name = "ext8", columnDefinition = "VARCHAR(20) COMMENT '扩展1'")
    private String ext8;
    /**
     * 扩展2
     */
    @Column(name = "ext9", columnDefinition = "VARCHAR(20) COMMENT '扩展2'")
    private String ext9;
    /**
     * 扩展3
     */
    @Column(name = "ext10", columnDefinition = "VARCHAR(20) COMMENT '扩展3'")
    private String ext10;
    /**
     * 1:工业企业，2:建筑工程,3:规模以上服务业，4:物流企业，5：场所相对密闭人员
     */
    @Column(name = "type", columnDefinition = "VARCHAR(20) COMMENT '1:工业企业，2:建筑工程,3:规模以上服务业，4:物流企业，5：场所相对密闭人员'")
    private String type;
    /**
     * 创建时间
     */
    /*@Column(name = "create_time", columnDefinition = "datetime) COMMENT '创建时间'")
    private Date create_time;*/

}
