package com.github.maximkirko.wpserver.web.controller;

import com.github.maximkirko.wpserver.datamodel.Ticket;
import com.github.maximkirko.wpserver.service.api.ITicketService;
import com.github.maximkirko.wpserver.web.converter.ModelToTicket;
import com.github.maximkirko.wpserver.web.model.TicketModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/android")
public class TicketController {

    @Autowired
    private ITicketService ticketService;

    private ModelToTicket modelToTicket = new ModelToTicket();

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> getTicket(@RequestBody TicketModel model) {

        Ticket ticket = modelToTicket.convert(model);
        ticketService.save(ticket);

        return new ResponseEntity<Void>(HttpStatus.CREATED);

    }

}

//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Void> createNewAnswer(@RequestBody AnswerModel answerModel) {
//
//        service.save(model2entity(answerModel));//modelConverter.convert(answerModel));
//        return new ResponseEntity<Void>(HttpStatus.CREATED);
//
//    }