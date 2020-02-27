package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseNativeEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 防控洞察-重点人员摸排表
 * @author zhaoweiming
 * @date 2020/2/26 10:20
 */
@Data
@Entity
@Table(name = "yndp_fkdc_zdrymp")
public class YndpFkdcZdrymp extends BaseNativeEntity {

    /**
     * 重点人员名称
     */
    @Column(name = "zdrymc", columnDefinition = "VARCHAR(64) COMMENT '重点人员名称'")
    private String zdrymc;
    /**
     * 重点人员人数
     */
    @Column(name = "zdryrs", columnDefinition = "VARCHAR(64) COMMENT '重点人员人数'")
    private String zdryrs;
    /**
     * 重点人员人数占比
     */
    @Column(name = "zdryrszb", columnDefinition = "VARCHAR(64) COMMENT '重点人员人数占比'")
    private String zdryrszb;
    /**
     * 重点人员新增人数
     */
    @Column(name = "zdryxzrs", columnDefinition = "VARCHAR(64) COMMENT '重点人员新增人数'")
    private String zdryxzrs;
    /**
     * 重点人员类型
     */
    @Column(name = "zdrylx", columnDefinition = "VARCHAR(64) COMMENT '重点人员类型（1 特殊人群 2 入住留验点人员 3登记在册 4公安检查点排查人员）'")
    private String zdrylx;
    /**
     * 排序
     */
    @Column(name = "px", columnDefinition = "VARCHAR(64) COMMENT '排序'")
    private String px;
    /**
     * 类型：1:区级，2：街道级，3：社区级别
     */
    @Column(name = "type", columnDefinition = "VARCHAR(2) COMMENT '类型：1:区级，2：街道级，3：社区级别'")
    private String type;
    /**
     * 机构ID
     */
    @Column(name = "jgid", columnDefinition = "VARCHAR(64) COMMENT '机构ID'")
    private String jgid;

}
