package com.ratel.modules.jladmin.service;

import com.ratel.framework.core.service.BaseService;
import com.ratel.framework.utils.QueryHelp;
import com.ratel.modules.jladmin.domain.TestDomain;
import com.ratel.modules.jladmin.respository.TestRepository;
import com.ratel.modules.jladmin.rest.dto.TestQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TestService extends BaseService<TestDomain, Long> {

    @Autowired
    private TestRepository testRepository;


    public List<TestDomain> queryAll(TestQueryCriteria criteria) {
        return testRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder));
    }

    public Page queryAll(TestQueryCriteria criteria, Pageable pageable) {
        Page<TestDomain> page = testRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return page;
    }

    public TestDomain getUser(TestDomain user) {
        return testRepository.getOne(user.getId());
    }
}
