package com.ratel.modules.yndp.domain;

import cn.hutool.core.date.DateTime;
import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 第一屏-应对疫情工作领导小组/指挥部
 * @author DDXS
 * @date 2020/3/17 15:11
 */
@Data
@Entity
@Table(name = "yndp_one_page_leading_group")
public class YndpOneLeadingGroup extends YndpBaseUuidEntity {
    /**
     * 组长/指挥长
     */
    @Column(name = "fitst_leader", columnDefinition = "VARCHAR(1000) COMMENT '组长/指挥长'")
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
     * 工作职责
     */
    @Column(name = "message", columnDefinition = "VARCHAR(2000) COMMENT '工作职责'")
    private String message;

    /**
     * 1:应对疫情工作领导小组 2:指挥部
     */
    @Column(name = "type", columnDefinition = "VARCHAR(2000) COMMENT '1:应对疫情工作领导小组 2:指挥部'")
    private String type;

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
