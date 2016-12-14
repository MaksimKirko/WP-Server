import com.github.maximkirko.wpserver.datamodel.*;
import com.github.maximkirko.wpserver.datamodel.action.Action;
import com.github.maximkirko.wpserver.datamodel.violation.Violation;
import com.github.maximkirko.wpserver.service.api.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by MadMax on 30.11.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app_context.xml")
public class ServiceTest {

    @Autowired
    private ITicketService ticketService;

    @Autowired
    private IViolationService violationService;

    @Autowired
    private IActionService actionService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Test
    public void defaultTest() {

    }

    //    @Test
//    public void deleteTest() {
//
//        ticketService.delete(3l);
//
//    }
//
//    @Test
//    public void actionInsertTest() {
//
//        Action action = new Action();
//        action.setType(ActionEnum.AssignFee);
//        action.setDescription("desc");
//
//        actionService.save(action);
//    }
//
//    @Test
//    public void violationInsertTest() {
//
//        Action action = new Action();
//        action.setType(ActionEnum.CallATowTruck);
//        action.setDescription("desc");
//
//        actionService.save(action);
//
//        Violation violation = new Violation();
//        violation.setType(ViolationEnum.ParkingAtBusStop);
//        violation.setFee(50f);
//        violation.setDescription("desc");
//        Set<Action> actions = new HashSet<>();
//        actions.add(action);
//
//        violation.setActions(actions);
//
//        violationService.save(violation);
//
//    }

//    @Test
//    public void ticketInsertTest() throws IOException {
//
//        Ticket ticket = new Ticket();
//        ticket.setType(TicketEnum.NOT_PROCESSED);
//        ticket.setDate(new Date());
//        ticket.setAddress("ул. Кирова, 32");
//        ticket.setLocation("53.678409, 23.837026");
//        ticket.setLicensePlate("LP 1234");
//
//
//        Violation violation = violationService.getById(1l);
//        Action action = actionService.getById(1l);
//
//        Set<Action> actions = new HashSet<Action>();
//        actions.add(action);
//
//        ticket.setActions(actions);
//
//        ticket.setViolation(violation);
//
//        Photo photo = new Photo();
//
//        BufferedImage originalImage = ImageIO.read(new File(
//                "pics//images.jpg"));
//
//        photo.setPhoto(Photo.getByteArrayPhoto(originalImage));
//        photo.setTicket(ticket);
//
//        Set<Photo> photoSet = new HashSet<>();
//        photoSet.add(photo);
//
//        ticket.setViolationPhotos(photoSet);
//
//        ticketService.save(ticket);
//
//    }

//    @Test
//    public void ticketGetTest() throws IOException {
//
//        Ticket ticket = ticketService.getById(1l);
//
//        BufferedImage img = Photo.getBufferedImagePhoto(ticket.getViolationPhotos().iterator().next().getPhoto());
//
//        ImageIO.write(img, "png", new File(
//                "pic_from_db.png"));
//
//    }


//    @Test
//    public void insertUserTest() {
//
//        User user = new User();
//        user.setLogin("kek");
//        user.setPassword("$2a$10$8jQqUK4f4fttnOE6T80lYu8SnNftLu2hmXgAyrcSmJznMUZo93DWW");
//        user.setFirstName("Pavel");
//        user.setLastName("Bulaj");
//        user.setEmail("another email");
//
//        Role role = roleService.getByType(RoleEnum.ADMIN);
//
//        user.setRole(role);
//
//        userService.save(user);
//    }
}
