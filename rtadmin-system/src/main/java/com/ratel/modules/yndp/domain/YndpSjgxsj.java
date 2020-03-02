package com.ratel.modules.yndp.domain;

import com.ratel.framework.core.domain.BaseUuidEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 数据时间更新表
 * @author DDXS
 * @date 2020/3/2 16:07
 */

@Data
@Entity
@Table(name = "yndp_sjgxsj")
public class YndpSjgxsj extends BaseUuidEntity {

    /**
     * 数据更新时间
     */
    @Column(name = "sjgxsj", columnDefinition = "VARCHAR(20) COMMENT '数据更新时间'")
    private String sjgxsj;


}
