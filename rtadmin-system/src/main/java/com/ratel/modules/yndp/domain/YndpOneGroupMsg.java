package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 第一屏-各小组信息
 * @author DDXS
 * @date 2020/3/17 15:11
 */
@Data
@Entity
@Table(name = "yndp_one_page_group_msg")
public class YndpOneGroupMsg extends YndpBaseUuidEntity {

    /**
     *  组 组长/指挥长
     */
    @Column(name = "fitst_leader", columnDefinition = "VARCHAR(1000) COMMENT '组 组长/指挥长'")
    private String fitst_leader;

    /**
     * 副组长/副指挥长
     */
    @Column(name = "second_leader", columnDefinition = "VARCHAR(1000) COMMENT '副组长/副指挥长'")
    private String second_leader;

    /**
     * 成员
     */
    @Column(name = "member", columnDefinition = "VARCHAR(1000) COMMENT '成员'")
    private String member;

    /**
     * 联络员
     */
    @Column(name = "contact_officer", columnDefinition = "VARCHAR(1000) COMMENT '联络员'")
    private String contact_officer;

    /**
     * 工作职责
     */
    @Column(name = "message", columnDefinition = "VARCHAR(2000) COMMENT '工作职责'")
    private String message;

    /**
     * 1：外事组 2：综合组（专班）3：宣传组 4：疫情防控组 5：医疗治疗组  6：交通管控组 7：教育防控组 8：文化旅游防控组 9：物资保障组 10：慰问组 11：督导组
     */
    @Column(name = "type", columnDefinition = "VARCHAR(32) COMMENT '1：外事组 2：综合组（专班）3：宣传组 4：疫情防控组 5：医疗治疗组  6：交通管控组 7：教育防控组 8：文化旅游防控组 9：物资保障组 10：慰问组 11：督导组'")
    private String type;

    /**
     * 带班领导
     */
    @Column(name = "temp_leader", columnDefinition = "VARCHAR(1000) COMMENT '带班领导'")
    private String temp_leader;

    /**
     * 一组
     */
    @Column(name = "first_group", columnDefinition = "VARCHAR(1000) COMMENT '一组'")
    private String first_group;

    /**
     * 二组
     */
    @Column(name = "second_group", columnDefinition = "VARCHAR(20) COMMENT '二组'")
    private String second_group;

    /**
     * 创建时间
     */
    @Column(name = "create_time", columnDefinition = "VARCHAR(20) COMMENT '创建时间'")
    private Date create_time;

    /**
     * 扩展1
     */
    @Column(name = "ext1", columnDefinition = "VARCHAR(32) COMMENT '扩展1'")
    private String ext1;

    /**
     * 扩展2
     */
    @Column(name = "ext2", columnDefinition = "VARCHAR(32) COMMENT '扩展2'")
    private String ext2;

}
