package com.ratel.modules.system.domain;

import com.ratel.framework.core.domain.BaseNativeEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;


@Getter
@Setter
@Accessors(chain = true)
@Access(AccessType.FIELD)
@Entity
@Table(name = "dict_detail")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DictDetail extends BaseNativeEntity {

    /** 字典标签 */
    @Column(name = "label",nullable = false)
    private String label;

    /** 字典值 */
    @Column(name = "value",nullable = false)
    private String value;

    /** 排序 */
    @Column(name = "sort")
    private String sort = "999";

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "dict_id")
    private Dict dict;

}
