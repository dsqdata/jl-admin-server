package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 宣传报道
 * @author xujinliang
 * @date 2020/3/9 10:10
 */
@Data
@Entity
@Table(name = "yndp_three_page_report")
public class YndpThreePageReport extends YndpBaseUuidEntity {

    /**
     * id
     */
    @Column(name = "id", columnDefinition = "VARCHAR(32) COMMENT '主键ID'")
    private String id;
    /**
     * 填报日期（yyyymmdd）
     */
    @Column(name = "date", columnDefinition = "VARCHAR(20) COMMENT '填报日期（yyyymmdd）'")
    private String date;
    /**
     * 媒体累计报道篇数
     */
    @Column(name = "media", columnDefinition = "VARCHAR(20) COMMENT '媒体累计报道篇数 '")
    private String media;
    /**
     * 两微一端报道条数
     */
    @Column(name = "wechat", columnDefinition = "VARCHAR(20) COMMENT '两微一端报道条数'")
    private String wechat;
    /**
     * 微信群个数
     */
    @Column(name = "twomicro", columnDefinition = "VARCHAR(20) COMMENT '微信群个数'")
    private String twomicro;
    /**
     * 受众人数
     */
    @Column(name = "audience", columnDefinition = "VARCHAR(20) COMMENT '受众人数'")
    private String audience;
    /**
     * 悬挂粘贴宣传标语
     */
    @Column(name = "slogan", columnDefinition = "VARCHAR(20) COMMENT '悬挂粘贴宣传标语'")
    private String slogan;
    /**
     * 发放防疫宣传单
     */
    @Column(name = "leaflets", columnDefinition = "VARCHAR(20) COMMENT '发放防疫宣传单'")
    private String leaflets;
    /**
     * 发送短信
     */
    @Column(name = "shortmessage", columnDefinition = "VARCHAR(20) COMMENT '发送短信'")
    private String shortmessage;
    /**
     * 滚动LED电子屏播放防疫宣传
     */
    @Column(name = "led", columnDefinition = "VARCHAR(20) COMMENT '滚动LED电子屏播放防疫宣传'")
    private String led;
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



}
