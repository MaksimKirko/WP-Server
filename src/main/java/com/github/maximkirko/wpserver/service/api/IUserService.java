package com.github.maximkirko.wpserver.service.api;


import com.github.maximkirko.wpserver.datamodel.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MadMax on 27.11.2016.
 */
public interface IUserService {

    User getById(Long id);

    User getByLogin(String login);

    List<User> getAll();

    @Transactional
    Long save(User user);

    @Transactional
    void saveAll(List<User> userList);

    @Transactional
    void delete(Long id);
}
