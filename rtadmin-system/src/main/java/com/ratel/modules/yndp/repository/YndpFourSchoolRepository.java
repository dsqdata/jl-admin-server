package com.ratel.modules.yndp.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.yndp.domain.YndpFourSchool;
import com.ratel.modules.yndp.domain.YndpFourSchoolMsg;
import com.ratel.modules.yndp.domain.YndpThreePageSchool;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

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
    @Query(nativeQuery = true, value = "select count(*) from yndp_four_school")
    YndpFourSchool getXxzs();

    /**
     * 学校图例
     * @author xjl
     * @date 2020/3/9
     */
    @Query(nativeQuery = true, value = "select  count(type) count,type type,CASE  WHEN ext3 =1  THEN  '托幼机构' WHEN ext3 =2  THEN  '小学' WHEN ext3 =3 THEN '初中' WHEN ext3 =4 THEN '大专院校' END 'type1' \n" +
            "from yndp_four_school   GROUP BY type ORDER BY type")
    List<YndpFourSchool> getXxtl();




    /**
     * 学校各种情况分类数
     * @author xjl
     * @date 2020/3/9
     */
    @Query(nativeQuery = true, value = "select  count(DISTINCT(school_id)) ext21  from yndp_four_school_msg   where ext21 >0 and DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') and  school_id in(SELECT  id from yndp_four_school) \n" +
            "UNION ALL\n" +
            "select  count(DISTINCT(school_id)) ext25  from yndp_four_school_msg   where ext25 >0 and DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') and  school_id in(SELECT  id from yndp_four_school) \n" +
            "UNION ALL\n" +
            "select  count(DISTINCT(school_id)) ext26  from yndp_four_school_msg   where ext26 >0 and DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') and  school_id in(SELECT  id from yndp_four_school) \n" +
            "UNION ALL\n" +
            "select  count(DISTINCT(school_id)) ext27  from yndp_four_school_msg   where ext27 >0 and DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') and  school_id in(SELECT  id from yndp_four_school) ")
    List<String> getXxfls(String date);


    /**
     * 各学校在昆教职工情况跟踪-有发热、咳嗦、呼吸困难等症状 统计数
     * @author xjl
     * @date 2020/3/9
     */
    @Query(nativeQuery = true, value = "SELECT s.name school_id,a.ext21 FROM\n" +
            "\t(SELECT school_id, sum(ext21) ext21 FROM yndp_four_school_msg\n" +
            "\t\tWHERE ext21 > 0 and DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') GROUP BY school_id ) a, yndp_four_school s  where a.school_id=s.id ORDER BY ext21 desc")
    List<YndpFourSchoolMsg> getXxtjs21(String date);

    /**
     * 各学校在昆教职工情况跟踪-新发感染病例统计数
     * @author xjl
     * @date 2020/3/9
     */
    @Query(nativeQuery = true, value = "SELECT s.name school_id,a.ext25 FROM\n" +
            "\t(SELECT school_id, sum(ext25) ext25 FROM yndp_four_school_msg\n" +
            "\t\tWHERE ext25 > 0 and DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') GROUP BY school_id ) a, yndp_four_school s  where a.school_id=s.id ORDER BY ext25 desc")
    List<YndpFourSchoolMsg> getXxtjs25(String date);

    /**
     * 各学校在昆教职工情况跟踪-确诊病例统计数
     * @author xjl
     * @date 2020/3/9
     */
    @Query(nativeQuery = true, value = "SELECT s.name school_id,a.ext26 FROM\n" +
            "\t(SELECT school_id, sum(ext26) ext26 FROM yndp_four_school_msg\n" +
            "\t\tWHERE ext26 > 0 and DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') GROUP BY school_id ) a, yndp_four_school s  where a.school_id=s.id ORDER BY ext26 desc")
    List<YndpFourSchoolMsg> getXxtjs26(String date);

    /**
     * 各学校在昆教职工情况跟踪-疑似病例 统计数
     * @author xjl
     * @date 2020/3/9
     */
    @Query(nativeQuery = true, value = "SELECT s.name school_id,a.ext27 FROM\n" +
            "\t(SELECT school_id, sum(ext27) ext27 FROM yndp_four_school_msg\n" +
            "\t\tWHERE ext27 > 0  and DATE_FORMAT(date, 'Y%m%d') = DATE_FORMAT(?1, 'Y%m%d') GROUP BY school_id ) a, yndp_four_school s  where a.school_id=s.id ORDER BY ext27 desc")
    List<YndpFourSchoolMsg> getXxtjs27(String date);

}
