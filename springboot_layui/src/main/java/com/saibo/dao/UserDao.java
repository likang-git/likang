package com.saibo.dao;

import com.saibo.model.User;
import com.saibo.model.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
@Component
public interface UserDao {
    List<User> queryUserList(UserVo userVo);

    User getUser(String userName);

    int saveUser(User user);

    //     int deleteUser(Long id);
    User getUserById(Long id);

    void updateUser(User user);

    int deleteUser(Long id1);

    int deleteUsers(Long[] ids);

    List<User> likeName(@Param("name") String name);

    int getCount(UserVo userVo);


}
