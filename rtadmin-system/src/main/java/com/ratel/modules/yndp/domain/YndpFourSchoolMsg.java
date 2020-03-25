package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 校园疫情防控-学校疫情信息
 * @author GXP
 * @date 2020/2/26 8:47
 */
@Data
@Entity
@Table(name = "yndp_four_school_msg")
public class YndpFourSchoolMsg extends YndpBaseUuidEntity {

    /**
     * 对应yndp_schoole 表的ID
     */
    @Column(name = "school_id ", columnDefinition = "VARCHAR(32) COMMENT '对应yndp_schoole 表的ID'")
    private String school_id ;
    /**
     * 数据更新时间(yyyymmdd)
     */
    @Column(name = "date", columnDefinition = "VARCHAR(32) COMMENT '数据更新时间(yyyymmdd)'")
    private String date;
    /**
     * 1:教职工，2:学生
     */
    @Column(name = "type", columnDefinition = "INT COMMENT '1:教职工，2:学生'")
    private String type;
    /**
     * 教职工流动情况跟踪-教职工总数
     */
    @Column(name = "ext11", columnDefinition = "INT COMMENT '教职工流动情况跟踪-教职工总数'")
    private int ext11;
    /**
     * 教职工流动情况跟踪-截止目前在昆教职工数
     */
    @Column(name = "ext12", columnDefinition = "INT COMMENT '教职工流动情况跟踪-截止目前在昆教职工数'")
    private int ext12;
    /**
     * 教职工流动情况跟踪-截止目前在其他州教职工数
     */
    @Column(name = "ext13", columnDefinition = "INT COMMENT '教职工流动情况跟踪-截止目前在其他州教职工数'")
    private int ext13;
    /**
     * 教职工流动情况跟踪-在湖北（含武汉）人数
     */
    @Column(name = "ext14", columnDefinition = "INT COMMENT '教职工流动情况跟踪-在湖北（含武汉）人数'")
    private int ext14;
    /**
     * 教职工流动情况跟踪-在其他省外人数
     */
    @Column(name = "ext15", columnDefinition = "INT COMMENT '教职工流动情况跟踪-在其他省外人数'")
    private int ext15;
    /**
     * 在昆教职工情况跟踪-有发热、咳嗦、呼吸困难等症状
     */
    @Column(name = "ext21", columnDefinition = "INT COMMENT '在昆教职工情况跟踪-有发热、咳嗦、呼吸困难等症状'")
    private int ext21;
    /**
     * 在昆教职工情况跟踪-外出后返昆未满15天
     */
    @Column(name = "ext22", columnDefinition = "INT COMMENT '在昆教职工情况跟踪-外出后返昆未满15天'")
    private int ext22;
    /**
     * 在昆教职工情况跟踪-正在进行隔离观察（治疗）
     */
    @Column(name = "ext23", columnDefinition = "INT COMMENT '在昆教职工情况跟踪-正在进行隔离观察（治疗）'")
    private int ext23;
    /**
     * 在昆教职工情况跟踪-与确诊及疑似密切接触未满15天
     */
    @Column(name = "ext24", columnDefinition = "INT COMMENT '在昆教职工情况跟踪-与确诊及疑似密切接触未满15天'")
    private int ext24;
    /**
     * 在昆教职工情况跟踪-新发感染病例
     */
    @Column(name = "ext25", columnDefinition = "INT COMMENT '在昆教职工情况跟踪-新发感染病例'")
    private int ext25;
    /**
     * 在昆教职工情况跟踪-确诊病例
     */
    @Column(name = "ext26", columnDefinition = "INT COMMENT '在昆教职工情况跟踪-确诊病例'")
    private int ext26;
    /**
     * 在昆教职工情况跟踪-疑似病例
     */
    @Column(name = "ext27", columnDefinition = "INT COMMENT '在昆教职工情况跟踪-疑似病例'")
    private int ext27;
    /**
     * 所有教职工到疫源地既往史-到湖北（含武汉）情况-总人数
     */
    @Column(name = "ext31", columnDefinition = "INT COMMENT '所有教职工到疫源地既往史-到湖北（含武汉）情况-总人数'")
    private int ext31;
    /**
     * 所有教职工到疫源地既往史-到湖北（含武汉）情况-已返昆人数
     */
    @Column(name = "ext32", columnDefinition = "INT COMMENT '所有教职工到疫源地既往史-到湖北（含武汉）情况-已返昆人数'")
    private int ext32;
    /**
     * 所有教职工到疫源地既往史-到武汉情况-总人数
     */
    @Column(name = "ext33", columnDefinition = "INT COMMENT '所有教职工到疫源地既往史-到武汉情况-总人数'")
    private int ext33;
    /**
     * 所有教职工到疫源地既往史-到武汉情况-已返昆人数
     */
    @Column(name = "ext34", columnDefinition = "INT COMMENT '所有教职工到疫源地既往史-到武汉情况-已返昆人数'")
    private int ext34;
    /**
     * 扩展1
     */
    @Column(name = "ext1", columnDefinition = "INT COMMENT '扩展1'")
    private int ext1;
    /**
     * 扩展2
     */
    @Column(name = "ext2", columnDefinition = "INT COMMENT '扩展2'")
    private int ext2;
    /**
     * 扩展3
     */
    @Column(name = "ext3", columnDefinition = "INT COMMENT '扩展3'")
    private int ext3;
    /**
     * 扩展4
     */
    @Column(name = "ext4", columnDefinition = "INT COMMENT '扩展4'")
    private int ext4;
    /**
     * 扩展5
     */
    @Column(name = "ext5", columnDefinition = "VARCHAR(500) COMMENT '扩展5'")
    private String ext5;
    /**
     * 扩展6
     */
    @Column(name = "ext6", columnDefinition = "VARCHAR(500) COMMENT '扩展6'")
    private String ext6;
    /**
     * 扩展7
     */
    @Column(name = "ext7", columnDefinition = "VARCHAR(500) COMMENT '扩展7'")
    private String ext7;

    /**
     * 创建时间
     */
    /*@Column(name = "create_time", columnDefinition = "datetime) COMMENT '创建时间'")
    private Date create_time;*/

}
