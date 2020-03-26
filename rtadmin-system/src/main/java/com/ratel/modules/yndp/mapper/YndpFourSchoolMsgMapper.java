package com.ratel.modules.yndp.mapper;

import com.ratel.modules.yndp.domain.YndpFourSchoolMsg;
import org.springframework.stereotype.Component;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author GXP
 * @date 2020/3/3 22:32
 */
@Component
public interface YndpFourSchoolMsgMapper {
    
    List<YndpFourSchoolMsg> getAllPeopleMsgList(@Param("date")String date,@Param("school_id")String school_id);

    List<YndpFourSchoolMsg> getAllMsgList(@Param("date")String date);

    List<YndpFourSchoolMsg> getYndpFourSchoolMsgList(@Param("date")String date,@Param("school_id")String school_id,@Param("type")int type);

    List<YndpFourSchoolMsg> getAllSchoolMsgList(@Param("date")String date,@Param("type")int type);

}
