package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Transient;

/**
 *
 * 校园疫情防控-学校信息
 * @author xujinliang
 * @date 2020/3/9 10:10
 */
@Data
@Entity
@Table(name = "yndp_four_school")
public class YndpFourSchool extends YndpBaseUuidEntity {

    /**
     * id
     */
    @Column(name = "id", columnDefinition = "VARCHAR(20) COMMENT 'id'")
    private String id;

    @Transient
    private String count;

    @Transient
    private String xxfl;
    /**
     * 学校名称
     */
    @Column(name = "name", columnDefinition = "VARCHAR(20) COMMENT '学校名称 '")
    private String name;
    /**
     * 1:托幼机构2:小学3:初中4:大专院校
     */
    @Column(name = "type", columnDefinition = "VARCHAR(20) COMMENT '1:托幼机构2:小学3:初中4:大专院校'")
    private String type;
    /**
     * 经度
     */
    @Column(name = "longitude", columnDefinition = "VARCHAR(20) COMMENT '经度'")
    private String longitude;

    /**
     * 纬度
     */
    @Column(name = "latitude", columnDefinition = "VARCHAR(20) COMMENT '纬度'")
    private String latitude;

    /**
     * 0:有效1:无效
     */
    @Column(name = "del_flag", columnDefinition = "VARCHAR(20) COMMENT '0:有效1:无效 '")
    private String del_flag;

    /**
     * 创建日期
     */
    @Column(name = "create_time", columnDefinition = "VARCHAR(20) COMMENT '创建日期'")
    private Date create_time;




}
