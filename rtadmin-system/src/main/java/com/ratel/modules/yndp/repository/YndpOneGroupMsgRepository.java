package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpOneGroupMsg;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 第一屏-各小组信息
 * @author DDXS
 * @date 2020/3/17 15:58
 */
@Repository
public interface YndpOneGroupMsgRepository extends BaseRepository<YndpOneGroupMsg, String> {

    //根据类型查询各小组信息
    @Query(nativeQuery = true, value = "select * from yndp_one_page_group_msg where type=?1")
    List<YndpOneGroupMsg> getGroupMsgByType(String type);


    @Query(nativeQuery = true, value = "select * from yndp_one_page_group_msg")
    List<YndpOneGroupMsg> getGroupMsgAll();


}
