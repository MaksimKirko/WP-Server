package com.github.maximkirko.wpserver.dao.api;

import com.github.maximkirko.wpserver.datamodel.Ticket;

import java.util.List;

/**
 * Created by Max on 29.11.2016.
 */
public interface ITicketDao {

    Ticket getById(Long id);

    List<Ticket> getAll();

    Long insert(Ticket ticket);

    Long update(Ticket ticket);

    void deleteById(Long id);
}
