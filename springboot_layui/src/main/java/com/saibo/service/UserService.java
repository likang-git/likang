package com.saibo.service;

import com.saibo.dao.UserDao;
import com.saibo.model.User;
import com.saibo.model.UserVo;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public List<User> queryUserList(UserVo userVo) {
        return userDao.queryUserList(userVo);
    }

    public User getUser(String userName) {
        return userDao.getUser(userName);
    }

    public int saveUser(User user) {
        return userDao.saveUser(user);
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public int deleteUser(String id) {
        String[] ids = id.split(",");
        if (ids.length > 0) {
            return userDao.deleteUsers((Long[]) ConvertUtils.convert(ids, Long.class));
        } else {
            return userDao.deleteUser(Long.parseLong(id) );
        }

    }

    public List<User> likeName(String name) {
        return userDao.likeName(name);
    }

    public int getCount(UserVo userVo) {
      return   userDao.getCount(userVo);
    }
}

