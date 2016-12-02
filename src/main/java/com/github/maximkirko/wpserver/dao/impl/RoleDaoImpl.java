package com.github.maximkirko.wpserver.dao.impl;


import com.github.maximkirko.wpserver.dao.api.IRoleDao;
import com.github.maximkirko.wpserver.dao.util.HibernateUtil;
import com.github.maximkirko.wpserver.datamodel.Role;
import com.github.maximkirko.wpserver.datamodel.RoleEnum;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements IRoleDao {

	private Session session;

	public RoleDaoImpl() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@Override
	public Role getById(Long id) {

		Role role = session.get(Role.class, id);

		return role;
	}

	@Override
	public Role getByType(RoleEnum type) {

		Role role = (Role) session.createCriteria(Role.class)
				.add(Restrictions.eq("type", type.toString()))
				.uniqueResult();

		return role;
	}

	@Override
	public List<Role> getAll() {

		List<Role> list = session.createCriteria(Role.class).list();

		return list;
	}

	@Override
	public Long insert(Role role) {

		session.beginTransaction();
		session.save(role);
		session.getTransaction().commit();

		return role.getId();
	}

	@Override
	public Long update(Role role) {

		session.beginTransaction();
		session.update(role);
		session.getTransaction().commit();

		return role.getId();
	}

	@Override
	public void deleteById(Long id) {

		Role role = getById(id);

		if (role != null) {
			session.beginTransaction();
			session.delete(role);
			session.getTransaction().commit();
		}
	}
}
