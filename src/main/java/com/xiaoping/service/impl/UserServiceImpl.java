package com.xiaoping.service.impl;

import com.xiaoping.dao.UserDao;
import com.xiaoping.entity.User;
import com.xiaoping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User register(User user) {
        user.setDisplayName(user.getUserName());
        user.setCreateTime(new Date());
        user.setLastLoginTime(new Date());
        return userDao.save(user);
    }

    @Override
    public User login(User user) {
        return userDao.findByUserNameAndPassword(user.getUserName(), user.getPassword());
    }

    @Override
    public User changePwd(User user) {
        return null;
    }

    @Override
    public User changeUserInfo(User user) {
        return null;
    }

    @Override
    public User findByName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
