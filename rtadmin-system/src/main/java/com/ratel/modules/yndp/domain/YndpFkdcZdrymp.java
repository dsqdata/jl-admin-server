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
     * 排查特殊人群数量总数
     */
    @Column(name = "pctsrqslzs", columnDefinition = "VARCHAR(64) COMMENT '排查特殊人群数量总数'")
    private String pctsrqslzs;
    /**
     * 排查特殊人群新增总人数
     */
    @Column(name = "pctsrqxzzrs", columnDefinition = "VARCHAR(64) COMMENT '排查特殊人群新增总人数'")
    private String pctsrqxzzrs;
    /**
     * 重点人员类型
     */
    @Column(name = "zdrylx", columnDefinition = "VARCHAR(64) COMMENT '重点人员类型'")
    private String zdrylx;
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
     * 入住留验点人员总数
     */
    @Column(name = "rzlydryzs", columnDefinition = "VARCHAR(64) COMMENT '入住留验点人员总数'")
    private String rzlydryzs;
    /**
     * 入住留验点人员新增总人数
     */
    @Column(name = "rzlydryxzzrs", columnDefinition = "VARCHAR(64) COMMENT '入住留验点人员新增总人数'")
    private String rzlydryxzzrs;
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
