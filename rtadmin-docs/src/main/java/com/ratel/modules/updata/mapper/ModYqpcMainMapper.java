package com.ratel.modules.updata.mapper;

import cn.hutool.db.PageResult;
import com.ratel.modules.updata.domain.YqpcMain;
import org.springframework.stereotype.Component;

@Component
public interface ModYqpcMainMapper {
    YqpcMain getOne(Long id);

    PageResult findPage();
}
