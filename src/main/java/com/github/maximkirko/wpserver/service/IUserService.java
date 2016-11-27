package com.github.maximkirko.wpserver.service;

import com.github.maximkirko.wpserver.datamodel.User;

import java.util.List;

/**
 * Created by MadMax on 27.11.2016.
 */
public interface IUserService {

    User getById(Long id);

    User getByLogin(String login);

    Long save(User user);

    void saveAll(List<User> userList);

    void delete(Long id);
}
