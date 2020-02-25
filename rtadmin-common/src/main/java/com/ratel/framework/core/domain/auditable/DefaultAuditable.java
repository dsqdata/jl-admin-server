package com.ratel.framework.core.domain.auditable;

import java.util.Date;

public interface DefaultAuditable {

    void setCreateUserName(String userName);

    void setCreateAccountId(Long accountId);

    void setDataDomain(String dataDomain);

    String getDataDomain();

    void setCreateTime(Date createDate);

    Date getCreateTime();

    void setUpdateUserName(String userName);

    void setUpdateAccountId(Long accountId);

    void setUpdateTime(Date updateDate);

    Date getUpdateTime();

    void setSystemDeptId(Long deptId);

}
