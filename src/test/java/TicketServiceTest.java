import com.github.maximkirko.wpserver.datamodel.*;
import com.github.maximkirko.wpserver.datamodel.action.Action;
import com.github.maximkirko.wpserver.datamodel.action.ActionEnum;
import com.github.maximkirko.wpserver.datamodel.violation.Violation;
import com.github.maximkirko.wpserver.datamodel.violation.ViolationEnum;
import com.github.maximkirko.wpserver.datamodel.violation.impl.ParkingOnGrass;
import com.github.maximkirko.wpserver.service.api.IActionService;
import com.github.maximkirko.wpserver.service.api.ITicketService;
import com.github.maximkirko.wpserver.service.api.IUserService;
import com.github.maximkirko.wpserver.service.api.IViolationService;
import com.github.maximkirko.wpserver.service.impl.ActionServiceImpl;
import com.github.maximkirko.wpserver.service.impl.TicketServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by MadMax on 30.11.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app_context.xml")
public class TicketServiceTest {

    @Inject
    private ITicketService ticketService;

    @Inject
    private IViolationService violationService;

    @Inject
    private IActionService actionService;

    @Inject
    private IUserService userService;

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
//        action.setType(ActionEnum.CallATowTrack);
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
//
//    @Test
//    public void ticketInsertTest() {
//
//        Ticket ticket = new Ticket();
//        ticket.setType(TicketEnum.NOT_PROCESSED);
//        ticket.setDate(new Date());
//        ticket.setLocation("loc");
//        ticket.setLicensePlate("LP 1234");
//
//        Action action = new Action();
//        action.setType(ActionEnum.CallATowTrack);
//        action.setDescription("desc");
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
//        ticket.setViolation(violationService.getById(2l));
//
//        Photo photo = new Photo();
//        photo.setPhoto(new byte[5]);
//
//        Set<Photo> photoSet = new HashSet<>();
//        photoSet.add(photo);
//
//        ticket.setViolationPhotos(photoSet);
//
//        ticketService.save(ticket);
//
//    }

//
//    @Test
//    public void insertUserTest() {
//
//        User user = new User();
//        user.setLogin("bad");
//        user.setPassword("qwerty");
//        user.setFirstName("Maxim");
//        user.setLastName("Kirko");
//        user.setEmail("email");
//
//        Role role = new Role();
//        role.setType(RoleEnum.ADMIN);
//
//        user.setRole(role);
//
//        userService.save(user);
//    }
}
