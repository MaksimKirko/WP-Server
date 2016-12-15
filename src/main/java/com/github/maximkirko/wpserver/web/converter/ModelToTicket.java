package com.github.maximkirko.wpserver.web.converter;

import com.github.maximkirko.wpserver.datamodel.Ticket;
import com.github.maximkirko.wpserver.datamodel.TicketEnum;
import com.github.maximkirko.wpserver.datamodel.violation.Violation;
import com.github.maximkirko.wpserver.service.api.IViolationService;
import com.github.maximkirko.wpserver.web.model.TicketModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by MadMax on 15.12.2016.
 */
public class ModelToTicket {

    @Autowired
    private IViolationService violationService;

    public Ticket convert(TicketModel model) {

        Ticket ticket = new Ticket();
        ticket.setViolationPhotos(model.getViolationPhotos());
        ticket.setLicensePlate(model.getLicensePlate());
        ticket.setLocation(model.getLocation());
        ticket.setAddress(model.getAddress());
        Violation violation = violationService.getByType(model.getViolation());
        ticket.setViolation(violation);
        ticket.setDate(model.getDate());
        ticket.setType(TicketEnum.NOT_PROCESSED);
        ticket.setComment(model.getComment());

        return ticket;
    }
}
