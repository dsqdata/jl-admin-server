package com.ratel.modules.demo.respository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.system.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoRepository extends BaseRepository<User, Long> {


    //-------jpql查询--------

    //根据用户id和firstName查询
    @Query(value = "from User where id = ?2 and firstName = ?1")
    User findUserByIdAndName(String username, int id);


    @Query("select s from User s where s.id = :id")
    Page<User> selectAllByUserId(@Param("id") Long userId, Pageable pageable);

    //-------sql查询--------

    @Query(value = "select * from user where nick_name like ?", nativeQuery = true)
    List<User> sqlFindByName(String nickName);

    @Query(value = "SELECT * FROM user WHERE nick_name = ?1",
            countQuery = "SELECT count(*) FROM user WHERE nick_name = ?1",
            nativeQuery = true)
    Page<User> findByLastname(String nickName, Pageable pageable);


    //-------方法命名查询--------

    //排序
    List<User> findByUsername(String username, Sort sort);

    //根据firstName与LastName查找(两者必须在数据库有)
    User findByUsernameAndNickName(String usename, String nickName);

    //根据firstName或LastName查找(两者其一有就行)
    User findByUsernameOrNickName(String usename, String nickName);

    //根据firstName查找它是否存在数据库里<类似与以下关键字>
    //User findByUsername(String usename);
    User findByUsernameIs(String usename);

}
