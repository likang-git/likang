package com.saibo.service;

import com.saibo.dao.LogDao;
import com.saibo.model.Log;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogService {
    @Resource
    private LogDao logDao;
    public List<Log> logList(Log log) {
        return  logDao.logList(log);
    }

    public int saveLog(Log log) {
        return logDao.saveLog(log);
    }

    public int getCount(Log log) {
        return  logDao.getCount(log);
    }
}
