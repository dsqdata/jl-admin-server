package com.ratel.modules.msg.domain;

import com.ratel.framework.core.domain.BaseNativeEntity;
import com.ratel.modules.system.domain.User;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Access(AccessType.FIELD)
@Entity
@Table(name = "sys_NotifyMessageRead", uniqueConstraints = @UniqueConstraint(columnNames = {"notifyMessage_id", "readUser_id"}))
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@MetaData(value = "公告阅读记录")
public class NotifyMessageRead extends BaseNativeEntity {

    private static final long serialVersionUID = -2680515888038751963L;

    //@MetaData(value = "公告")
    @ManyToOne
    @JoinColumn(name = "notifyMessage_id", nullable = false)
    private NotifyMessage notifyMessage;

    //@MetaData(value = "阅读用户")
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "readUser_id", nullable = false)
    private User readUser;

    //@MetaData(value = "首次阅读时间")
    @Column(nullable = false, updatable = false)
    private LocalDateTime firstReadTime;

    //@MetaData(value = "最后阅读时间")
    private LocalDateTime lastReadTime;

    //@MetaData(value = "总计阅读次数")
    @Column(nullable = false)
    private Integer readTotalCount = 1;

    @Override
    @Transient
    public String getDisplay() {
        return null;
    }
}
