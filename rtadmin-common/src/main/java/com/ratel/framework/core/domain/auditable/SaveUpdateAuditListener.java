package com.ratel.framework.core.domain.auditable;

import com.ratel.framework.core.GlobalConstant;
import com.ratel.framework.security.vo.JwtUser;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * 审计记录记录创建和修改信息
 *
 * @see AuditingEntityListener
 */
public class SaveUpdateAuditListener {

    @PrePersist
    public void touchForCreate(Object target) {

        if (!(target instanceof DefaultAuditable)) {
            return;
        }
        DefaultAuditable auditable = (DefaultAuditable) target;
        if (auditable.getCreateTime() == null) {
            auditable.setCreateTime(new Date());
            //设置初始更新时间为创建时间，便于有些业务按照更新时间降序排列的需求
            auditable.setUpdateTime(new Date());
        }

        try {
            JwtUser user= (JwtUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            auditable.setCreateAccountId(user.getId());
            auditable.setCreateUserName(user.getUsername());
            auditable.setSystemDeptId(user.getDeptId());
            auditable.setUpdateAccountId(user.getId());
            auditable.setUpdateUserName(user.getUsername());
        }catch (Exception e){

        }
        auditable.setDataDomain(GlobalConstant.DEFAULT_VALUE);
    }

    @PreUpdate
    public void touchForUpdate(Object target) {
        if (!(target instanceof DefaultAuditable)) {
            return;
        }
        DefaultAuditable auditable = (DefaultAuditable) target;
        auditable.setUpdateTime(new Date());
        try {
            JwtUser user= (JwtUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            auditable.setUpdateAccountId(user.getId());
            auditable.setUpdateUserName(user.getUsername());
        }catch (Exception e){

        }
    }
}
