package com.github.maximkirko.wpserver.dao.api;

import com.github.maximkirko.wpserver.datamodel.Role;
import com.github.maximkirko.wpserver.datamodel.RoleEnum;

import java.util.List;

public interface IRoleDao {

    Role getById(Long id);

    Role getByType(RoleEnum type);

    List<Role> getAll();

    Long insert(Role role);

    Long update(Role role);

    void deleteById(Long id);
}