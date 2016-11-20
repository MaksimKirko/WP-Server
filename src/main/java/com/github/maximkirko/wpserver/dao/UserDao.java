package com.github.maximkirko.wpserver.dao;

import com.github.maximkirko.wpserver.dao.util.HibernateUtil;
import com.github.maximkirko.wpserver.datamodel.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDao {

    private Session session;

    public UserDao() {

        session = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Save an AddressBook object to the database
     */
    public void save(User user) {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }
}  