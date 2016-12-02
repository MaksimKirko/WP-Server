package com.github.maximkirko.wpserver.service.api;


import com.github.maximkirko.wpserver.datamodel.Role;
import com.github.maximkirko.wpserver.datamodel.RoleEnum;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IRoleService {

	Role getById(Long id);

	Role getByType(RoleEnum type);

	List<Role> getAll();

	@Transactional
	Long save(Role role);

	@Transactional
	void saveAll(List<Role> roleList);

	@Transactional
	void delete(Long id);
}
