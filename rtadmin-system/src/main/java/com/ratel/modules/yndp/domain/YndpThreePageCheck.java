package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 疫情工作动态-三类重点目标人群核查
 * @author GXP
 * @date 2020/2/26 8:47
 */
@Data
@Entity
@Table(name = "yndp_three_page_check")
public class YndpThreePageCheck extends YndpBaseUuidEntity {

    /**
     * 填报日期
     */
    @Column(name = "date", columnDefinition = "VARCHAR(20) COMMENT '填报日期'")
    private String date;
    /**
     * 第一类昨日推送人数
     */
    @Column(name = "first_yesterday", columnDefinition = "VARCHAR(20) COMMENT '第一类昨日推送人数'")
    private String first_yesterday;
    /**
     * 第一类昨日推送-涉及经开区人数
     */
    @Column(name = "first_jkq", columnDefinition = "VARCHAR(20) COMMENT '第一类昨日推送-涉及经开区人数'")
    private String first_jkq;
    /**
     * 第一类状态
     */
    @Column(name = "first_status", columnDefinition = "VARCHAR(20) COMMENT '第一类状态'")
    private String first_status;
    /**
     * 第二类昨日推送人数
     */
    @Column(name = "second_yesterday", columnDefinition = "VARCHAR(20) COMMENT '第二类昨日推送人数'")
    private String second_yesterday;
    /**
     * 第二类昨日推送-涉及经开区人数
     */
    @Column(name = "second_jkq", columnDefinition = "VARCHAR(20) COMMENT '第二类昨日推送-涉及经开区人数'")
    private String second_jkq;
    /**
     * 第二类状态
     */
    @Column(name = "second_status", columnDefinition = "VARCHAR(20) COMMENT '微信群覆盖率-累计'")
    private String second_status;
    /**
     * 第三类昨日推送人数
     */
    @Column(name = "third_yesterday", columnDefinition = "VARCHAR(20) COMMENT '第三类昨日推送人数 '")
    private String third_yesterday;
    /**
     * 第三类昨日推送-涉及经开区人数
     */
    @Column(name = "third_jkq", columnDefinition = "VARCHAR(20) COMMENT '第三类昨日推送-涉及经开区人数 '")
    private String third_jkq;
    /**
     * 第三类状态
     */
    @Column(name = "third_status", columnDefinition = "VARCHAR(20) COMMENT '第三类状态'")
    private String third_status;
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
