package com.github.maximkirko.wpserver.service.impl;

import com.github.maximkirko.wpserver.dao.api.ITicketDao;
import com.github.maximkirko.wpserver.datamodel.Ticket;
import com.github.maximkirko.wpserver.service.api.ITicketService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Max on 29.11.2016.
 */

@Service
public class TicketServiceImpl implements ITicketService {

    @Inject
    private ITicketDao ticketDao;

    @Override
    public Ticket getById(Long id) {
        return ticketDao.getById(id);
    }

    @Override
    public List<Ticket> getAll() {
        return ticketDao.getAll();
    }

    @Override
    public Long save(Ticket ticket) {

        Long id = null;

        if (ticket.getId() == null) {
            id = ticketDao.insert(ticket);
        } else {
            id = ticketDao.update(ticket);
        }
        return id;
    }

    @Override
    public void saveAll(List<Ticket> ticketList) {
        for (Ticket ticket : ticketList) {
            save(ticket);
        }
    }

    @Override
    public void delete(Long id) {
        ticketDao.deleteById(id);
    }
}
