package com.github.maximkirko.wpserver.web.controller;

import com.github.maximkirko.wpserver.datamodel.Ticket;
import com.github.maximkirko.wpserver.datamodel.action.ActionEnum;
import com.github.maximkirko.wpserver.datamodel.violation.ViolationEnum;
import com.github.maximkirko.wpserver.service.api.ITicketService;
import com.github.maximkirko.wpserver.service.api.IUserService;
import com.github.maximkirko.wpserver.service.impl.TicketServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Pavel on 13.11.2016.
 */
@Controller
public class MainController {

    @Inject
    private ITicketService ticketService;

    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public ModelAndView welcomePage() {

        ModelAndView model = new ModelAndView();
        /*model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is welcome page!");*/
        model.setViewName("hello");
        return model;

    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page!");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {



        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Неверное имя пользователя или пароль!");
        }

        if (logout != null) {
            model.addObject("msg", "Вы успешно вышли из аккаунта.");
        }
        model.setViewName("login");

        return model;

    }


    @RequestMapping(value = "/app**", method = RequestMethod.GET)
    public ModelAndView appPage() {

        List<Ticket> inputTickets = ticketService.getAll();

        List<String> rusViolations = ViolationEnum.getRusViolationsList();

        List<String> rusActions = ActionEnum.getRusActionList();

        ModelAndView model = new ModelAndView();

        model.addObject("rusActions", rusActions);
        model.addObject("rusViolations", rusViolations);
        model.addObject("inputTickets",inputTickets);
        model.setViewName("app");

        return model;

    }


}
