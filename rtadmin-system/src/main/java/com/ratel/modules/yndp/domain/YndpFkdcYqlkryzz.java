package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseNativeEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 防控洞察-疫区来昆人员追踪表
 * @author zhaoweiming
 * @date 2020/2/26 11:10
 */
@Data
@Entity
@Table(name = "yndp_fkdc_yqlkryzz")
public class YndpFkdcYqlkryzz extends BaseNativeEntity {

    /**
     * 人员类型
     */
    @Column(name = "rylx", columnDefinition = "VARCHAR(64) COMMENT '人员类型'")
    private String rylx;
    /**
     * 人员数量
     */
    @Column(name = "rysl", columnDefinition = "VARCHAR(64) COMMENT '人员数量'")
    private String rysl;
    /**
     * 日期
     */
    @Column(name = "rq", columnDefinition = "VARCHAR(20) COMMENT '日期'")
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
