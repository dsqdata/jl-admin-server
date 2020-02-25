package com.ratel.modules.monitor.domain;

import lombok.Data;
import com.ratel.framework.core.domain.BaseEntity;

import javax.persistence.*;

/**
 * pv 与 ip 统计
 */
@Entity
@Data
@Table(name = "visits")
public class Visits extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String date;

    @Column(name = "pv_counts")
    private Long pvCounts;

    @Column(name = "ip_counts")
    private Long ipCounts;

    @Column(name = "week_day")
    private String weekDay;
}
