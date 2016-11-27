package com.github.maximkirko.wpserver;


import com.github.maximkirko.wpserver.dao.impl.UserDao;

/**
 * Created by Pavel on 12.10.2016.
 */
public class Program {
    public static void main(String[] args) {

//        User user = new User();
//        user.setLogin("user");
//        user.setPassword("password");

//        Ticket ticket = new Ticket();
//        ticket.setLicensePlate("AHGSDF");
//        ticket.setDate(new Date());
//        ticket.setLocation("1, 2");
//
//        Set<Ticket> tickets = new HashSet<Ticket>();
//        tickets.add(ticket);
//        user.setTickets(tickets);

        UserDao userDao = new UserDao();

        System.out.println(userDao.getByLogin("maks"));


//        User user = userDao.getById(3l);
//        user.setPassword("qwas");
//
//        userDao.update(user);
//        System.out.println(user.getId());

        //System.out.println(userDao.getById(3l));

//        List<User> users = userDao.getAll();
//
//        for (User user : users) {
//            System.out.println(user);
//        }

    }
}
