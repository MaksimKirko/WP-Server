package com.github.maximkirko.wpserver.dao;

import com.github.maximkirko.wpserver.datamodel.User;

import java.util.List;

/**
 * Created by MadMax on 27.11.2016.
 */

public interface IUserDao {

    User getById(Long id);

    User getByLogin(String login);

    List<User> getAll();

    Long insert(User user);

    Long update(User user);

    void deleteById(Long id);
}
