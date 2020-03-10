package com.ratel.modules.yndp.domain;

import com.ratel.modules.yndp.entity.YndpBaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 第三屏：其他疫情信息播报
 * @author DDXS
 * @date 2020/3/9 14:12
 */
@Data
@Entity
@Table(name = "yndp_three_page_broadcast")
public class YndpThreePageBroadcast extends YndpBaseUuidEntity {
    /**
     * 播报日期(yyyymmdd)
     */
    @Column(name = "date", columnDefinition = "VARCHAR(32) COMMENT '播报日期(yyyymmdd)'")
    private String date;
    /**
     * 播报内容
     */
    @Column(name = "content", columnDefinition = "VARCHAR(32) COMMENT '播报内容'")
    private String content;
    /**
     * 创建时间
     */
    @Column(name = "create_time", columnDefinition = "VARCHAR(20) COMMENT ' 创建时间'")
    private Date create_time;
}
