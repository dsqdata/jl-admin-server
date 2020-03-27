package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFourSchool;
import com.ratel.modules.yndp.domain.YndpFourSchoolMsg;
import com.ratel.modules.yndp.domain.YndpThreePageSchool;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * 学校复工情况
 * @author xjl
 * @date 2020/3/9
 */
@Repository
public interface YndpFourSchoolRepository extends BaseRepository<YndpFourSchool, String> {



    /**
     * 学校总数
     * @author xjl
     * @date 2020/3/9
     */
    @Query(nativeQuery = true, value = "select * from yndp_four_school where name LIKE %?1% ORDER BY type ")
    List<YndpFourSchool> getXxjw(String name);

    /**
     * 学校总数
     * @author xjl
     * @date 2020/3/9
     */
    @Query(nativeQuery = true, value = "select count(*) from yndp_four_school")
    String getXxzs();

    /**
     * 学校图例
     * @author xjl
     * @date 2020/3/9
     */
    @Query(nativeQuery = true, value = "select  count(type) count,type type,CASE  WHEN type =1  THEN  '托幼机构' WHEN type =2  THEN  '小学' WHEN type =3 THEN '初中' WHEN type =4 THEN '大专院校' END 'xxfl' \n" +
            "from yndp_four_school   GROUP BY type ORDER BY type")
    List<Map> getXxtl();




    /**
     * 学校各种情况分类数
     * @author xjl
     * @date 2020/3/9
     */
    @Query(nativeQuery = true, value = "select  count(DISTINCT(school_id)) ext25  from yndp_four_school_msg   where ext25 >0 and DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') and  school_id in(SELECT  id from yndp_four_school) \n" +
            "UNION ALL\n" +
            "select  count(DISTINCT(school_id)) ext26  from yndp_four_school_msg   where ext26 >0 and DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') and  school_id in(SELECT  id from yndp_four_school) \n" +
            "UNION ALL\n" +
            "select  count(DISTINCT(school_id)) ext27  from yndp_four_school_msg   where ext27 >0 and DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') and  school_id in(SELECT  id from yndp_four_school) \n" +
            "UNION ALL\n" +
            "select  count(DISTINCT(school_id)) ext21  from yndp_four_school_msg   where ext21 >0 and DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') and  school_id in(SELECT  id from yndp_four_school) ")
    List<String> getXxfls(String date);


    /**
     * 各学校在昆教职工情况跟踪-有发热、咳嗦、呼吸困难等症状 统计数
     * @author xjl
     * @date 2020/3/9
     */
    @Query(nativeQuery = true, value = "SELECT s.id school_id,s.name name,a.ext21  ext21 FROM\n" +
            "\t(SELECT school_id, sum(ext21) ext21 FROM yndp_four_school_msg\n" +
            "\t\tWHERE ext21 > 0 and DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') GROUP BY school_id ) a, yndp_four_school s  where a.school_id=s.id and s.name LIKE %?2% ORDER BY ext21 desc")
    List<Map> getXxtjs21(String date,String name);

    /**
     * 各学校在昆教职工情况跟踪-新发感染病例统计数
     * @author xjl
     * @date 2020/3/9
     */
    @Query(nativeQuery = true, value = "SELECT s.id school_id,s.name name,a.ext25 FROM\n" +
            "\t(SELECT school_id, sum(ext25) ext25 FROM yndp_four_school_msg\n" +
            "\t\tWHERE ext25 > 0 and DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') GROUP BY school_id ) a, yndp_four_school s  where a.school_id=s.id and s.name LIKE %?2% ORDER BY ext25 desc")
    List<Map> getXxtjs25(String date,String name);

    /**
     * 各学校在昆教职工情况跟踪-确诊病例统计数
     * @author xjl
     * @date 2020/3/9
     */
    @Query(nativeQuery = true, value = "SELECT s.id school_id,s.name name,a.ext26 FROM\n" +
            "\t(SELECT school_id, sum(ext26) ext26 FROM yndp_four_school_msg\n" +
            "\t\tWHERE ext26 > 0 and DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') GROUP BY school_id ) a, yndp_four_school s  where a.school_id=s.id and s.name LIKE %?2% ORDER BY ext26 desc")
    List<Map> getXxtjs26(String date,String name);

    /**
     * 各学校在昆教职工情况跟踪-疑似病例 统计数
     * @author xjl
     * @date 2020/3/9
     */
    @Query(nativeQuery = true, value = "SELECT s.id school_id,s.name name,a.ext27 FROM\n" +
            "\t(SELECT school_id, sum(ext27) ext27 FROM yndp_four_school_msg\n" +
            "\t\tWHERE ext27 > 0  and DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') GROUP BY school_id ) a, yndp_four_school s  where a.school_id=s.id and s.name LIKE %?2% ORDER BY ext27 desc")
    List<Map> getXxtjs27(String date,String name);

}
