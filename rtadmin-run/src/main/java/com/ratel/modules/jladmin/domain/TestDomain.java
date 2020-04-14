package com.ratel.modules.jladmin.domain;

import com.ratel.framework.core.domain.BaseNativeEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "test_domain")
public class TestDomain extends BaseNativeEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String username;

    @Column
    private String nickName;

    @Column
    private Integer age;
}
