package com.ratel.modules.demo.domain;

import com.ratel.framework.core.domain.BaseNativeEntity;
import lombok.Data;

import javax.persistence.Column;

/**
 *  id Long 类型
 *  public class DemoDomain extends BaseNativeEntity
 *
 *  id 复合主键 类型
 *  public class DemoWithMultiId extends BaseEntity
 *
 *  id String 类型
 *  public class DemoWithStringId extends BaseUuidEntity
 */
@Data
// @Entity
// @Table(name = "demo_with_long_id")
public class DemoDomain extends BaseNativeEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Integer age;

}
