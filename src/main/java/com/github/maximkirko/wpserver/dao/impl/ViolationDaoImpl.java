package com.github.maximkirko.wpserver.dao.impl;

import com.github.maximkirko.wpserver.dao.api.IViolationDao;
import com.github.maximkirko.wpserver.dao.util.HibernateUtil;
import com.github.maximkirko.wpserver.datamodel.violation.Violation;
import com.github.maximkirko.wpserver.datamodel.violation.ViolationEnum;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MadMax on 28.11.2016.
 */

@Repository
public class ViolationDaoImpl implements IViolationDao {

    private Session session;

    public ViolationDaoImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public Violation getById(Long id) {

        Violation violation = (Violation) session.get(Violation.class, id);

        return violation;
    }

    @Override
    public Violation getByType(ViolationEnum type) {

        Violation violation = (Violation) session.createCriteria(Violation.class)
                .add(Restrictions.eq("type", type.toString()))
                .uniqueResult();

        return violation;
    }

    @Override
    public List<Violation> getAll() {

        List<Violation> list = session.createCriteria(Violation.class).list();

        return list;
    }

    @Override
    public Long insert(Violation violation) {

        session.beginTransaction();
        session.save(violation);
        session.getTransaction().commit();

        return violation.getId();
    }

    @Override
    public Long update(Violation violation) {

        session.beginTransaction();
        session.update(violation);
        session.getTransaction().commit();

        return violation.getId();
    }

    @Override
    public void deleteById(Long id) {

        Violation violation = getById(id);

        if (violation != null) {
            session.beginTransaction();
            session.delete(violation);
            session.getTransaction().commit();
        }
    }
    
}
