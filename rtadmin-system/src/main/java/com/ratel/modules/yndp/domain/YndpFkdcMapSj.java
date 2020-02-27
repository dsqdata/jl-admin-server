package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseNativeEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 防控洞察-地图展示数据表
 * @author DDXS
 * @date 2020/2/27 10:53
 */
@Data
@Entity
@Table(name = "yndp_fkdc_map_sj")
public class YndpFkdcMapSj extends BaseNativeEntity {
    /**
     * 机构ID
     */
    @Column(name = "jgid", columnDefinition = "VARCHAR(64) COMMENT '机构ID'")
    private String jgid;
    /**
     * 机构名称
     */
    @Column(name = "jgmc", columnDefinition = "VARCHAR(64) COMMENT '机构名称'")
    private String jgmc;

    /**
     * 疫情事件
     */
    @Column(name = "yqsj", columnDefinition = "VARCHAR(64) COMMENT '疫情事件'")
    private String yqsj;

    /**
     * 摄像头
     */
    @Column(name = "sxt", columnDefinition = "VARCHAR(64) COMMENT '摄像头'")
    private String sxt;

    /**
     * 24小时内入境人数
     */
    @Column(name = "rjrs", columnDefinition = "VARCHAR(64) COMMENT '24小时内入境人数'")
    private String rjrs;
    /**
     * 24小时内入境人数(较昨日)
     */
    @Column(name = "rjrsjzr", columnDefinition = "VARCHAR(64) COMMENT '24小时内入境人数(较昨日)'")
    private String rjrsjzr;
    /**
     * 出现异常情况人数
     */
    @Column(name = "cxycqkrs", columnDefinition = "VARCHAR(64) COMMENT '出现异常情况人数'")
    private String cxycqkrs;
    /**
     * 出现异常情况人数(较昨日)
     */
    @Column(name = "cxycqkrsjzr", columnDefinition = "VARCHAR(64) COMMENT '出现异常情况人数(较昨日)'")
    private String cxycqkrsjzr;
    /**
     * 境内现有需追踪人数
     */
    @Column(name = "jnxyxzzrs", columnDefinition = "VARCHAR(64) COMMENT '境内现有需追踪人数'")
    private String jnxyxzzrs;
    /**
     * 境内现有需追踪人数(较昨日)
     */
    @Column(name = "jnxyxzzrsjzr", columnDefinition = "VARCHAR(64) COMMENT '境内现有需追踪人数(较昨日)'")
    private String jnxyxzzrsjzr;
    /**
     * 解除追踪人数
     */
    @Column(name = "jczzrs", columnDefinition = "VARCHAR(64) COMMENT '解除追踪人数'")
    private String jczzrs;
    /**
     * 解除追踪人数(较昨日)
     */
    @Column(name = "jczzrsjzr", columnDefinition = "VARCHAR(64) COMMENT '解除追踪人数(较昨日)'")
    private String jczzrsjzr;
    /**
     * 现存确诊
     */
    @Column(name = "xcqz", columnDefinition = "VARCHAR(64) COMMENT '现存确诊'")
    private String xcqz;
    /**
     * 现存确诊(较昨日)
     */
    @Column(name = "xcqzjzr", columnDefinition = "VARCHAR(64) COMMENT '现存确诊(较昨日)'")
    private String xcqzjzr;
    /**
     * 累计确诊
     */
    @Column(name = "ljqz", columnDefinition = "VARCHAR(64) COMMENT '累计确诊'")
    private String ljqz;
    /**
     * 累计确诊(较昨日)
     */
    @Column(name = "ljqzjzr", columnDefinition = "VARCHAR(64) COMMENT '累计确诊(较昨日)'")
    private String ljqzjzr;
    /**
     * 现存疑似
     */
    @Column(name = "xcys", columnDefinition = "VARCHAR(64) COMMENT '现存疑似'")
    private String xcys;
    /**
     * 现存疑似(较昨日)
     */
    @Column(name = "xcysjzr", columnDefinition = "VARCHAR(64) COMMENT '现存疑似(较昨日)'")
    private String xcysjzr;
    /**
     * 累计死亡
     */
    @Column(name = "ljsw", columnDefinition = "VARCHAR(64) COMMENT '累计死亡'")
    private String ljsw;
    /**
     * 累计死亡(较昨日)
     */
    @Column(name = "ljswjzr", columnDefinition = "VARCHAR(64) COMMENT '累计死亡(较昨日)'")
    private String ljswjzr;
    /**
     * 现存重症
     */
    @Column(name = "xczz", columnDefinition = "VARCHAR(64) COMMENT '现存重症'")
    private String xczz;
    /**
     * 现存重症(较昨日)
     */
    @Column(name = "xczzjzr", columnDefinition = "VARCHAR(64) COMMENT '现存重症(较昨日)'")
    private String xczzjzr;
    /**
     * 累计治愈
     */
    @Column(name = "ljzy", columnDefinition = "VARCHAR(64) COMMENT '累计治愈'")
    private String ljzy;
    /**
     * 累计治愈(较昨日)
     */
    @Column(name = "ljzyjzr", columnDefinition = "VARCHAR(64) COMMENT '累计治愈(较昨日)'")
    private String ljzyjzr;

}
