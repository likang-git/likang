package com.saibo.dao;

import com.saibo.model.Sign;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
@Component
public interface SignDao {

    int saveSign(Sign sign);

    int updateSign(Sign sign);

    Sign check(Sign sign);

    Sign getSign(String id);

    List<Sign> geSign(Long userId1);
}
