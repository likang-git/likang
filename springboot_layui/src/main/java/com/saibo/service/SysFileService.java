package com.saibo.service;

import com.saibo.dao.SysFileDao;
import com.saibo.model.SysFile;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysFileService {

    @Resource
    private SysFileDao sysFileDao;

    public void save(SysFile sysFile) {
        sysFileDao.save(sysFile);
    }

    public List<SysFile> getAll() {
     return    sysFileDao.getAll();
    }

    public SysFile getById(String id) {
        return sysFileDao.getById(id);
    }
}
