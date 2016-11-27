package com.github.maximkirko.wpserver.dao.impl;

import com.github.maximkirko.wpserver.dao.IUserDao;
import com.github.maximkirko.wpserver.dao.util.HibernateUtil;
import com.github.maximkirko.wpserver.datamodel.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDao implements IUserDao {

    private Session session;

    public UserDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public User getById(Long id) {

        User user = session.get(User.class, id);

        return user;
    }

    public User getByLogin(String login) {

        User user = (User) session.createCriteria(User.class)
                .add(Restrictions.eq("login", login))
                .uniqueResult();

        return user;
    }

    public List<User> getAll() {

        List<User> list = session.createCriteria(User.class).list();

        return list;
    }

    public Long insert(User user) {

        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();

        return user.getId();
    }

    public Long update(User user) {

        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();

        return user.getId();
    }

    public void deleteById(Long id) {

        User user = getById(id);

        if (user != null) {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }
    }
}