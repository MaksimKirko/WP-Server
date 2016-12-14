package com.github.maximkirko.wpserver.web.controller;

import com.github.maximkirko.wpserver.datamodel.Photo;
import com.github.maximkirko.wpserver.datamodel.Role;
import com.github.maximkirko.wpserver.datamodel.Ticket;
import com.github.maximkirko.wpserver.datamodel.TicketEnum;
import com.github.maximkirko.wpserver.datamodel.action.Action;
import com.github.maximkirko.wpserver.datamodel.action.ActionEnum;
import com.github.maximkirko.wpserver.datamodel.violation.Violation;
import com.github.maximkirko.wpserver.datamodel.violation.ViolationEnum;
import com.github.maximkirko.wpserver.service.api.*;
import com.github.maximkirko.wpserver.service.impl.TicketServiceImpl;
import com.github.maximkirko.wpserver.util.LocationProvider;
import com.github.maximkirko.wpserver.util.PhotoConverter;
import org.apache.commons.codec.binary.Base64;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Pavel on 13.11.2016.
 */
@Controller
public class MainController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ITicketService ticketService;

    @Autowired
    private IViolationService violationService;

    @Autowired
    private IActionService actionService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcomePage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("login");
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

        List<Ticket> allTickets = ticketService.getAll();

        List<Ticket> inputTickets = new ArrayList<>();
        List<Ticket> processedTickets = new ArrayList<>();
        List<Ticket> archivedTickets = new ArrayList<>();

        for (Ticket t : allTickets) {
            if (t.getType() == TicketEnum.NOT_PROCESSED) {
                inputTickets.add(t);
            } else if (t.getType() == TicketEnum.PROCESSED) {
                processedTickets.add(t);
            } else {
                archivedTickets.add(t);
            }
        }

        List<String> rusViolations = ViolationEnum.getRusViolationsList();
        List<ViolationEnum> violations = ViolationEnum.getViolations();


        List<String> rusActions = ActionEnum.getRusActionList();

        ModelAndView model = new ModelAndView();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");

        model.addObject("dateFormat", dateFormat);
        model.addObject("rusActions", rusActions);
        model.addObject("violations", violations);
        model.addObject("rusViolations", rusViolations);
        model.addObject("inputTickets", inputTickets);
        model.addObject("processedTickets", processedTickets);
        model.addObject("archivedTickets", archivedTickets);
        model.setViewName("app");

        return model;

    }

    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.GET)
    public ModelAndView ticketPage(@PathVariable("id") long id) throws UnsupportedEncodingException {
        Ticket chosenTicket = ticketService.getById(id);
        PhotoConverter photoConverter = new PhotoConverter();
        List<String> rusViolations = ViolationEnum.getRusViolationsList();
        List<ViolationEnum> violations = ViolationEnum.getViolations();
        List<ActionEnum> actions = ActionEnum.getActions();
        LocationProvider locationProvider = new LocationProvider();

        List<String> chosenStrPhotos = new ArrayList<>();
        for (Photo p : chosenTicket.getViolationPhotos()) {
            byte[] encodeBase64 = Base64.encodeBase64(p.getPhoto());
            String base64Encoded = new String(encodeBase64, "UTF-8");

            chosenStrPhotos.add("data:image/png;base64," + base64Encoded);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");


        ModelAndView model = new ModelAndView();

        model.addObject("locProv", locationProvider);
        model.addObject("dateFormat", dateFormat);
        model.addObject("photoConverter", photoConverter);
        model.addObject("actions", actions);
        model.addObject("violations", violations);
        model.addObject("rusViolations", rusViolations);
        model.addObject("chosenStrPhotos", chosenStrPhotos);
        model.addObject("chosenTicket", chosenTicket);
        model.setViewName("ticket");
        return model;
    }

    @RequestMapping(value = "/updateTicket", method = RequestMethod.POST)
    public ModelAndView updateTicket(@RequestParam(value = "curViol") String curViol, @RequestParam(value = "curId") long curId,
                                     @RequestParam(value = "actions") String[] actions) {
        ModelAndView model = new ModelAndView();

        Ticket newTicket = ticketService.getById(curId);

        Violation v = violationService.getByType(ViolationEnum.getViolation(curViol));

//        System.out.println();
//        for (String s: actions) {
//            System.out.println(s);
//        }
        Set<Action> newActions = new HashSet<Action>();

        for (String action: actions) {
            Action act = actionService.getByType(ActionEnum.getAction(action));
            System.out.println();
            System.out.println(act.toString());
            newActions.add(act);
        }

        newTicket.setActions(newActions);
        newTicket.setViolation(v);
        newTicket.setType(TicketEnum.PROCESSED);
        ticketService.save(newTicket);
        model.setViewName("redirect:/app");
        return model;
    }

    @RequestMapping(value = "/archiveTicket", method = RequestMethod.POST)
    public ModelAndView archiveTicket(@RequestParam(value = "curId") long curId) {
        ModelAndView model = new ModelAndView();

        Ticket ticket = ticketService.getById(curId);
        ticket.setType(TicketEnum.ARCHIVE);
        ticketService.save(ticket);

        model.setViewName("redirect:/app");
        return model;
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/login?logout";
//    }


    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }


    @ModelAttribute("roles")
    public List<Role> initializeProfiles() {
        return roleService.getAll();
    }


}
