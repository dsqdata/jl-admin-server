package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseNativeEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 防控洞察-事件表
 * @author DDXS
 * @date 2020/2/26 11:07
 */
@Data
@Entity
@Table(name = "yndp_fkdc_sj")
public class YndpFkdcSj extends BaseNativeEntity {

    /**
     * 市区
     */
    @Column(name = "sq", columnDefinition = "VARCHAR(64) COMMENT '市区'")
    private String sq;
    /**
     * 街道
     */
    @Column(name = "jiedao", columnDefinition = "VARCHAR(64) COMMENT '街道'")
    private String jiedao;
    /**
     * 社区
     */
    @Column(name = "shequ", columnDefinition = "VARCHAR(64) COMMENT '社区'")
    private String shequ;
    /**
     * 小区/村
     */
    @Column(name = "xq", columnDefinition = "VARCHAR(64) COMMENT '小区/村'")
    private String xq;

    /**
     * 事件
     */
    @Column(name = "sj", columnDefinition = "VARCHAR(64) COMMENT '事件'")
    private String sj;
    /**
     * 事件发生时间
     */
    @Column(name = "sjfssj", columnDefinition = "VARCHAR(20) COMMENT '事件发生时间'")
    private String sjfssj;


}
