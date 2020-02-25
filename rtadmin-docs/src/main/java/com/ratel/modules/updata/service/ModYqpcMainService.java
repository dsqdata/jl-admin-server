package com.ratel.modules.updata.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ratel.framework.core.service.BaseService;
import com.ratel.framework.utils.FileUtil;
import com.ratel.framework.utils.PageUtil;
import com.ratel.framework.utils.QueryHelp;
import com.ratel.modules.updata.domain.YqpcMain;
import com.ratel.modules.updata.mapper.ModYqpcMainMapper;
import com.ratel.modules.updata.repository.ModYqpcMainRepository;
import com.ratel.modules.updata.service.dto.YqpcQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ModYqpcMainService extends BaseService<YqpcMain, Long> {

    @Autowired
    private ModYqpcMainRepository modYqpcMainRepository;

    @Autowired
    ModYqpcMainMapper modYqpcMainMapper;

    public Map<String, Object> queryAll(YqpcQueryCriteria modDocs, Pageable pageable) {
        Page<YqpcMain> page = modYqpcMainRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, modDocs, cb), pageable);
        return PageUtil.toPage(page);
    }

    public List<YqpcMain> queryAll(YqpcQueryCriteria dict) {
        List<YqpcMain> list = modYqpcMainRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, dict, cb));
        return list;
    }

    public YqpcMain getOne(Long id){
        return modYqpcMainMapper.getOne(id);
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    public PageInfo<YqpcMain> findPage(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNumber();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<YqpcMain> sysMenus = modYqpcMainMapper.findPage();
        return new PageInfo<YqpcMain>(sysMenus);
    }

    public void download(List<YqpcMain> dictDtos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (YqpcMain deptDTO : dictDtos) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("部门名称", deptDTO.getName());
            map.put("部门状态", deptDTO.getType());
            map.put("创建日期", deptDTO.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}
