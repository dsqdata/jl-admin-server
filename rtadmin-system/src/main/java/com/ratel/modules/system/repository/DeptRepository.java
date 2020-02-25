package com.ratel.modules.system.repository;

import com.ratel.framework.core.repository.BaseRepository;
import com.ratel.modules.system.domain.Dept;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface DeptRepository extends BaseRepository<Dept, Long> {

    /**
     * 根据 PID 查询
     *
     * @param id pid
     * @return /
     */
    List<Dept> findByPid(Long id);

    /**
     * 根据ID查询名称
     *
     * @param id ID
     * @return /
     */
    @Query(value = "select name from dept where id = ?1", nativeQuery = true)
    String findNameById(Long id);

    /**
     * 根据角色ID 查询
     *
     * @param id 角色ID
     * @return /
     */
    Set<Dept> findByRoles_Id(Long id);

}
