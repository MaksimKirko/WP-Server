package com.github.maximkirko.wpserver.dao.api;


import com.github.maximkirko.wpserver.datamodel.User;

import java.util.List;

public interface IUserDao {

	User getById(Long id);

	User getByLogin(String login);

	List<User> getAll();

	Long insert(User user);

	Long update(User user);

    void deleteById(Long id);
}

