package com.github.maximkirko.wpserver.service.api;

import com.github.maximkirko.wpserver.datamodel.Ticket;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Max on 29.11.2016.
 */
public interface ITicketService {

    Ticket getById(Long id);

    List<Ticket> getAll();

    @Transactional
    Long save(Ticket ticket);

    @Transactional
    void saveAll(List<Ticket> ticketList);

    @Transactional
    void delete(Long id);
}
