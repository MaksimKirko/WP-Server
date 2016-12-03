package com.github.maximkirko.wpserver.service.impl;


import com.github.maximkirko.wpserver.dao.api.IRoleDao;
import com.github.maximkirko.wpserver.dao.api.IRoleDao;
import com.github.maximkirko.wpserver.datamodel.Role;
import com.github.maximkirko.wpserver.datamodel.RoleEnum;
import com.github.maximkirko.wpserver.service.api.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleDao roleDao;

	@Override
	public Role getById(Long id) {
		return roleDao.getById(id);
	}

	@Override
	public Role getByType(RoleEnum type) {
		return roleDao.getByType(type);
	}

	@Override
	public List<Role> getAll() {
		return roleDao.getAll();
	}

	@Override
	public Long save(Role role) {

		Long id = null;

		if (role.getId() == null) {
			id = roleDao.insert(role);
		} else {
			id = roleDao.update(role);
		}
		return id;
	}

	@Override
	public void saveAll(List<Role> roleList) {
		for (Role role : roleList) {
			save(role);
		}
	}

	@Override
	public void delete(Long id) {
		roleDao.deleteById(id);
	}

}
