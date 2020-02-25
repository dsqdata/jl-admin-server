package com.ratel.framework.core.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import com.ratel.framework.core.GlobalConstant;
import com.ratel.framework.core.domain.auditable.DefaultAuditable;
import com.ratel.framework.core.domain.auditable.SaveUpdateAuditListener;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.AuditOverrides;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Access(AccessType.FIELD)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "javassistLazyInitializer", "revisionEntity", "handler"}, ignoreUnknown = true)
@MappedSuperclass
@EntityListeners({SaveUpdateAuditListener.class})
@AuditOverrides({@AuditOverride(forClass = BaseEntity.class)})
public abstract class BaseEntity<ID extends Serializable> extends AbstractPersistableEntity<ID> implements DefaultAuditable {

    //乐观锁版本
    //@Version
    //@Column(name = "version", nullable = false)
    //private Integer version = 0;

    @Column(name = "create_user_name", length = 256, updatable = false)
    private String createUserName = GlobalConstant.NONE_VALUE;

    @Column(name = "create_account_id", length = 256, updatable = false)
    private Long createAccountId;

    @Column(name = "create_time", updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "update_time")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @Column(name = "update_user_name", length = 256)
    private String updateUserName;

    @Column(name = "update_account_id", length = 256)
    private Long updateAccountId;

    @Column(name = "system_dept_id")
    private Long systemDeptId;

    //	@MetaData(value = "数据隔离域", comments = "类似Windows域的概念，进行用户数据隔离")
    @Column(name = "data_domain", length = 100, updatable = false)
    private String dataDomain;

    //	@MetaData(value = "系统备注说明", comments = "预留一个通用的系统备注字段，业务根据需要合理使用")
    @Column(name = "system_remark", length = 1000, updatable = true)
    private String systemRemark;

    @Column(name = "system_status", length = 1)
    private String systemStatus = GlobalConstant.STATUS_VALUE;

    private static final String[] PROPERTY_LIST = new String[]{"id", "version"};

    public String[] retriveCommonProperties() {
        return PROPERTY_LIST;
    }

    @Override
    @Transient
    public String getDisplay() {
        return "[" + getId() + "]" + this.getClass().getSimpleName();
    }

    public @interface Update {
    }
}
