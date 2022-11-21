package com.chen.allannotation.service.impl;

import com.chen.allannotation.dao.IUserDao;
import com.chen.allannotation.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    @Override
    public void save() {
        System.out.println("service层保存方法......");
        iUserDao.save();
    }
}
