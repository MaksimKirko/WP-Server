package com.github.maximkirko.wpserver;


import com.github.maximkirko.wpserver.dao.UserDao;
import com.github.maximkirko.wpserver.dao.util.HibernateUtil;
import com.github.maximkirko.wpserver.datamodel.Ticket;
import com.github.maximkirko.wpserver.datamodel.User;
import com.github.maximkirko.wpserver.datamodel.violations.ParkingOnWalkway;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;

/**
 * Created by Pavel on 12.10.2016.
 */
public class Program {
    public static void main(String[] args) {

        User user = new User();
        user.setLogin("maks");
        user.setPassword("qwe");

        Ticket ticket = new Ticket();
        ticket.setLicensePlate("AHGSDF");
        ticket.setDate(new Date());
        ticket.setLocation("1, 2");

        Set<Ticket> tickets = new HashSet<Ticket>();
        tickets.add(ticket);
        user.setTickets(tickets);

        UserDao userDao = new UserDao();

        userDao.save(user);

    }
}
