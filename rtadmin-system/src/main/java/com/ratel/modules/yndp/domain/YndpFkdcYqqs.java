package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseNativeEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 防控洞察-疫情趋势表
 * @author zhaoweiming
 * @date 2020/2/26 10:10
 */
@Data
@Entity
@Table(name = "yndp_fkdc_yqqs")
public class YndpFkdcYqqs extends BaseNativeEntity {

    /**
     * 疫情名称
     */
    @Column(name = "yqmc", columnDefinition = "VARCHAR(64) COMMENT '疫情名称'")
    private String yqmc;
    /**
     * 疫情数量
     */
    @Column(name = "yqsl", columnDefinition = "VARCHAR(64) COMMENT '疫情数量'")
    private String yqsl;
    /**
     * 疫情类型(1新增疑似/新增确诊 2现存确诊/现存疑似 3死亡/治愈 4病死率 5治愈率)
     */
    @Column(name = "yqlx", columnDefinition = "VARCHAR(64) COMMENT '疫情类型(1新增疑似/新增确诊 2现存确诊/现存疑似 3死亡/治愈 4病死率 5治愈率)'")
    private String yqlx;
    /**
     * 排序
     */
    @Column(name = "px", columnDefinition = "VARCHAR(64) COMMENT '排序'")
    private String px;
    /**
     * 日期
     */
    @Column(name = "rq", columnDefinition = "DATE COMMENT '日期'")
    private String rq;
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
