package com.chen.allannotation.dao.impl;

import com.chen.allannotation.dao.IUserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao {
    @Override
    public void save() {
        System.out.println("Dao层保存.......");
    }
}
