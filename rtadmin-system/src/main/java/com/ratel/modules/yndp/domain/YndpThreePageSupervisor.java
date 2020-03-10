package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 *
 * 督导组工作开展
 * @author xujinliang
 * @date 2020/3/9 10:10
 */
@Data
@Entity
@Table(name = "yndp_three_page_supervisor")
public class YndpThreePageSupervisor extends YndpBaseUuidEntity {

    /**
     * 填报日期（yyyymmdd）
     */
    @Column(name = "date", columnDefinition = "VARCHAR(20) COMMENT '填报日期（yyyymmdd）'")
    private String date;
    /**
     * 督导类别
     */
    @Column(name = "type", columnDefinition = "VARCHAR(20) COMMENT '督导类别 '")
    private String type;
    /**
     * 工作开展内容描述
     */
    @Column(name = "content ", columnDefinition = "VARCHAR(20) COMMENT '工作开展内容描述'")
    private String content ;
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
     * 创建日期
     */
    @Column(name = "create_time", columnDefinition = "VARCHAR(20) COMMENT '创建日期'")
    private Date create_time;


}
