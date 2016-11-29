package com.github.maximkirko.wpserver.dao.impl;

import com.github.maximkirko.wpserver.dao.api.ITicketDao;
import com.github.maximkirko.wpserver.dao.util.HibernateUtil;
import com.github.maximkirko.wpserver.datamodel.Ticket;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Max on 29.11.2016.
 */
@Repository
public class TicketDaoImpl implements ITicketDao {

    private Session session;

    public TicketDaoImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Ticket getById(Long id) {

        Ticket ticket = session.get(Ticket.class, id);

        return ticket;
    }

    public List<Ticket> getAll() {

        List<Ticket> list = session.createCriteria(Ticket.class).list();

        return list;
    }

    public Long insert(Ticket ticket) {

        session.beginTransaction();
        session.save(ticket);
        session.getTransaction().commit();

        return ticket.getId();
    }

    public Long update(Ticket ticket) {

        session.beginTransaction();
        session.update(ticket);
        session.getTransaction().commit();

        return ticket.getId();
    }

    public void deleteById(Long id) {

        Ticket ticket = getById(id);

        if (ticket != null) {
            session.beginTransaction();
            session.delete(ticket);
            session.getTransaction().commit();
        }
    }
}
