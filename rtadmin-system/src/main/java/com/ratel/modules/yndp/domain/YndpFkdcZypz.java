package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseEntity;
import com.ratel.framework.core.domain.BaseNativeEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * 防控洞察-资源配置表
 * @author DDXS
 * @date 2020/2/25 14:10
 */
@Data
@Entity
@Table(name = "Yndp_Fkdc_Zypz")
public class YndpFkdcZypz extends BaseNativeEntity {

    /**
     * 网格长
     */
    @Column(name = "wgz", columnDefinition = "VARCHAR(64) COMMENT '网格长'")
    private String wgz;
    /**
     * 网格员
     */
    @NotBlank
    @Column(name = "wgy", columnDefinition = "VARCHAR(64) COMMENT '网格员'")
    private String wgy;
    /**
     * 楼栋长/单元长
     */
    @Column(name = "ldz", columnDefinition = "VARCHAR(64) COMMENT '楼栋长或单元长'")
    private String ldz;
    /**
     * 留验站点
     */
    @Column(name = "lyzd", columnDefinition = "VARCHAR(64) COMMENT '留验站点'")
    private String lyzd;
    /**
     * 医护人员
     */
    @Column(name = "yhry", columnDefinition = "VARCHAR(64) COMMENT '医护人员'")
    private String yhry;
    /**
     * 留观酒店
     */
    @Column(name = "lgjd", columnDefinition = "VARCHAR(64) COMMENT '留观酒店'")
    private String lgjd;
    /**
     * 警力支撑
     */
    @Column(name = "jlzc", columnDefinition = "VARCHAR(64) COMMENT '警力支撑'")
    private String jlzc;
    /**
     * 固定检查点
     */
    @Column(name = "gdjcd", columnDefinition = "VARCHAR(64) COMMENT '固定检查点'")
    private String gdjcd;
    /**
     * 视频卡口
     */
    @Column(name = "spkk", columnDefinition = "VARCHAR(64) COMMENT '视频卡口'")
    private String spkk;
    /**
     * 类型：1:区级，2：街道级，3：社区级别
     */
    @Column(name = "type", columnDefinition = "VARCHAR(2) COMMENT '类型：1:区级，2：街道级，3：社区级别'")
    private String type;
    /**
     * 机构ID
     */
    @Column(name = "jgid", columnDefinition = "VARCHAR(2) COMMENT '机构ID'")
    private String jgid;

}
