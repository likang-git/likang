package com.saibo.dao;

import com.saibo.model.SysFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysFileDao {
    void save(SysFile sysFile);

    List<SysFile> getAll();

    SysFile getById(String id);
}
