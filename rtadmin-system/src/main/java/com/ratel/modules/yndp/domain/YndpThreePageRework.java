package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 *
 * 企业复工复产
 * @author xujinliang
 * @date 2020/3/9 10:10
 */
@Data
@Entity
@Table(name = "yndp_three_page_rework")
public class YndpThreePageRework extends YndpBaseUuidEntity {

    /**
     * 填报日期（yyyymmdd）
     */
    @Column(name = "date", columnDefinition = "VARCHAR(20) COMMENT '填报日期（yyyymmdd）'")
    private String date;
    /**
     * 总数
     */
    @Column(name = "ext1", columnDefinition = "VARCHAR(20) COMMENT '总数'")
    private String ext1;

    /**
     * 复工数
     */
    @Column(name = "ext2", columnDefinition = "VARCHAR(20) COMMENT '复工数'")
    private String ext2;

    /**
     * 分类：1.工业企业；2.建筑工程；3.规模以上服务业；4.物流企业；5.上述相关封闭
     */
    @Column(name = "ext3", columnDefinition = "VARCHAR(20) COMMENT '分类：1.工业企业；2.建筑工程；3.规模以上服务业；4.物流企业；5.上述相关封闭'")
    private String ext3;

    /**
     * 扩展4
     */
    @Column(name = "ext4", columnDefinition = "VARCHAR(20) COMMENT ''")
    private String ext4;

    /**
     * 扩展5
     */
    @Column(name = "ext5", columnDefinition = "VARCHAR(20) COMMENT ''")
    private String ext5;

    /**
     * 扩展6
     */
    @Column(name = "ext6", columnDefinition = "VARCHAR(20) COMMENT ''")
    private String ext6;

    /**
     * 扩展7
     */
    @Column(name = "ext7", columnDefinition = "VARCHAR(20) COMMENT ''")
    private String ext7;

    /**
     * 扩展8
     */
    @Column(name = "ext8", columnDefinition = "VARCHAR(20) COMMENT ''")
    private String ext8;


}
