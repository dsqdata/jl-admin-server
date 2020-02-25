package com.ratel.modules.msg.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.ratel.framework.core.domain.BaseNativeEntity;
import com.ratel.framework.utils.DateUtils;
import com.ratel.framework.utils.WebFormatter;
import com.ratel.modules.system.domain.User;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@Access(AccessType.FIELD)
@Entity
@Table(name = "sys_AccountMessage")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//@MetaData(value = "账号消息", comments = "如果用户消息量担心影响查询效率，可以考虑引入定期归档处理把过期消息搬迁归档")
public class AccountMessage extends BaseNativeEntity {

    private static final long serialVersionUID = 1685596718660284598L;

    //@MetaData(value = "消息类型", comments = "从数据字典定义的消息类型")
    @Column(length = 32, nullable = true)
    private String type;

    //@MetaData(value = "标题")
    @Column(nullable = false)
    private String title;

    //@MetaData(value = "APP弹出提示内容", comments = "如果不为空则触发APP弹出通知，为空则不会弹出而只会推送应用消息")
    @Column(length = 200)
    private String notification;

    //@MetaData(value = "消息内容", comments = "可以是无格式的TEXT或格式化的HTMl，一般是在邮件或WEB页面查看的HTML格式详细内容")
    @Lob
    @Column(nullable = false)
    private String message;

    //@MetaData(value = "目标账号")
    @ManyToOne
    @JoinColumn(name = "targetAccount_id", nullable = false)
    private User targetAccount;

    //@MetaData(value = "发布时间", comments = "全局的消息创建时间")
    @Column(nullable = false)
    private Date publishTime;

    //@MetaData(value = "邮件推送消息")
    private Boolean emailPush = Boolean.FALSE;

    //@MetaData(value = "邮件推送消息时间", comments = "为空表示尚未推送过")
    private Date emailPushTime;

    //@MetaData(value = "APP推送消息")
    private Boolean appPush = Boolean.FALSE;

    //@MetaData(value = "APP推送消息时间", comments = "为空表示尚未推送过")
    private Date appPushTime;

    //@MetaData(value = "关联附件个数", comments = "用于列表显示和关联处理附件清理判断")
    private Integer attachmentSize;

    //@MetaData(value = "首次阅读时间")
    private Date firstReadTime;

    //@MetaData(value = "最后阅读时间")
    private Date lastReadTime;

    //@MetaData(value = "总计阅读次数")
    @Column(nullable = false)
    private Integer readTotalCount = 0;

    @Column(name = "filepath", columnDefinition = "LONGTEXT COMMENT '文档路径'")
    private String filepath;

    @Transient
    private String messageAbstract;

    @Transient
    private List<List<Long>> targetAccounts;

    @Transient
    public Set<Long> targetDepts;

    @Column(nullable = true)
    private String batchNo;

    @Override
    @Transient
    public String getDisplay() {
        return title;
    }


    @Transient
    public String getPublishTimeFormatted() {
        return publishTime == null ? "" : DateUtils.formatDate(publishTime, DateUtils.DEFAULT_TIME_FORMAT);
    }

    @Transient
    public String getMessageAbstract() {
        if (StringUtils.isNotBlank(notification)) {
            return notification;
        } else {
            //优化为提取HTML内容text摘要
            if (!StringUtils.isEmpty(message)) {
                return StringUtils.substring(WebFormatter.html2text(message), 0, 50).trim() + "...";
            } else {
                return "";
            }
        }
    }

    public void copy(AccountMessage source) {
        BeanUtil.copyProperties(source, this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
