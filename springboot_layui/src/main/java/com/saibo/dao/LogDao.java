package com.saibo.dao;

import com.saibo.model.Log;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
@Component
public interface LogDao {
    List<Log> logList(Log log);

    int saveLog(Log log);

    int getCount(Log log);
}

