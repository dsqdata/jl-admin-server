package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 疫情工作动态-留验站工作表
 * @author GXP
 * @date 2020/2/26 8:47
 */
@Data
@Entity
@Table(name = "yndp_three_page_workstation")
public class YndpThreePageWorkstation extends YndpBaseUuidEntity {

    /**
     * 留验站工作名称
     */
    @Column(name = "name", columnDefinition = "VARCHAR(32) COMMENT '留验站工作名称'")
    private String name;

    /**
     * 创建时间
     */
    /*@Column(name = "create_time", columnDefinition = "datetime) COMMENT '创建时间'")
    private Date create_time;*/

}
