import com.github.maximkirko.wpserver.datamodel.*;
import com.github.maximkirko.wpserver.datamodel.action.Action;
import com.github.maximkirko.wpserver.datamodel.action.ActionEnum;
import com.github.maximkirko.wpserver.datamodel.violation.impl.ParkingOnGrass;
import com.github.maximkirko.wpserver.service.api.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by MadMax on 30.11.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app_context.xml")
public class TicketServiceTest {

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
//        action.setType(ActionEnum.CallATowTruck);
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


    @Test
    public void insertUserTest() {

//        User user = new User();
//        user.setLogin("kek");
//        user.setPassword("$2a$10$8jQqUK4f4fttnOE6T80lYu8SnNftLu2hmXgAyrcSmJznMUZo93DWW");
//        user.setFirstName("Pavel");
//        user.setLastName("Bulaj");
//        user.setEmail("another email");

        Action action = actionService.getByType(ActionEnum.CallATowTruck);

        System.out.println(action.toString());

        Role role = roleService.getByType(RoleEnum.ADMIN);

        System.out.println(role.toString());

//        user.setRole(role);
//
//        userService.save(user);
    }
}
