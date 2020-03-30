package com.ratel.modules.demo.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.framework.utils.QueryHelp;
import com.ratel.modules.demo.respository.DemoRepository;
import com.ratel.modules.demo.rest.dto.DemoQueryCriteria;
import com.ratel.modules.system.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DemoService extends BaseService<User, Long> {

    @Autowired
    private DemoRepository demoRepository;


    public List<User> queryAll(DemoQueryCriteria criteria) {
        return demoRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder));
    }

    public Page queryAll(DemoQueryCriteria criteria, Pageable pageable) {
        Page<User> page = demoRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return page;
    }

    public User getUser(User user) {
        return demoRepository.getOne(user.getId());
    }
}
