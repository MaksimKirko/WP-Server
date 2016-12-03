package com.github.maximkirko.wpserver.service.impl;


import com.github.maximkirko.wpserver.dao.api.IUserDao;
import com.github.maximkirko.wpserver.datamodel.User;
import com.github.maximkirko.wpserver.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MadMax on 27.11.2016.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public User getByLogin(String login) {
        return userDao.getByLogin(login);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public Long save(User user) {

        Long id = null;

        if (user.getId() == null) {
            id = userDao.insert(user);
        } else {
            id = userDao.update(user);
        }
        return id;
    }

    @Override
    public void saveAll(List<User> userList) {
        for (User user : userList) {
            save(user);
        }
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }
}
