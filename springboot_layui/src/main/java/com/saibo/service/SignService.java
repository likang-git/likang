package com.saibo.service;

import com.saibo.dao.SignDao;
import com.saibo.model.Sign;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SignService {

    @Resource
    private SignDao signDao ;
    public int saveSign(Sign sign) {
        return signDao.saveSign(sign);
    }

    public int updateSign(Sign sign) {
        return signDao.updateSign(sign);
    }

    public Sign check(Sign sign) {
        return signDao.check(sign);
    }

    public Sign getSign(String id) {
        return signDao.getSign(id);
    }

    public List<Sign> geSign(Long userId1) {
        return signDao.geSign(userId1);
    }
}
