package com.github.maximkirko.wpserver.dao.impl;

import com.github.maximkirko.wpserver.dao.api.IActionDao;
import com.github.maximkirko.wpserver.dao.util.HibernateUtil;
import com.github.maximkirko.wpserver.datamodel.action.Action;
import com.github.maximkirko.wpserver.datamodel.action.ActionEnum;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MadMax on 28.11.2016.
 */

@Repository
public class ActionDaoImpl implements IActionDao {

    private Session session;

    public ActionDaoImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public Action getById(Long id) {

        Action action = session.get(Action.class, id);

        return action;
    }

    @Override
    public List<Action> getByType(ActionEnum type) {

        List<Action> actions = session.createCriteria(Action.class)
                .add(Restrictions.eq("type", type.toString()))
                .list();

        return actions;
    }

    @Override
    public List<Action> getAll() {

        List<Action> list = session.createCriteria(Action.class).list();

        return list;
    }

    @Override
    public Long insert(Action action) {

        session.beginTransaction();
        session.save(action);
        session.getTransaction().commit();

        return action.getId();
    }

    @Override
    public Long update(Action action) {

        session.beginTransaction();
        session.update(action);
        session.getTransaction().commit();

        return action.getId();
    }

    @Override
    public void deleteById(Long id) {

        Action action = getById(id);

        if (action != null) {
            session.beginTransaction();
            session.delete(action);
            session.getTransaction().commit();
        }
    }

}
