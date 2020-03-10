package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 疫情工作动态-物资保供
 * @author GXP
 * @date 2020/2/26 8:47
 */
@Data
@Entity
@Table(name = "yndp_three_page_support")
public class YndpThreePageSupport extends YndpBaseUuidEntity {

    /**
     * 填报日期
     */
    @Column(name = "date", columnDefinition = "VARCHAR(20) COMMENT '填报日期 '")
    private String date;
    /**
     * 生活物资状态
     */
    @Column(name = "living", columnDefinition = "VARCHAR(20) COMMENT '生活物资状态 '")
    private String living;
    /**
     * 防疫物资状态
     */
    @Column(name = "prevention", columnDefinition = "VARCHAR(20) COMMENT '防疫物资状态 '")
    private String prevention;
    /**
     * 资金保障状态
     */
    @Column(name = "capital", columnDefinition = "VARCHAR(20) COMMENT '资金保障状态'")
    private String capital;

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
