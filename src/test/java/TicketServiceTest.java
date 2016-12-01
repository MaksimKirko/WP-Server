import com.github.maximkirko.wpserver.datamodel.Photo;
import com.github.maximkirko.wpserver.datamodel.Role;
import com.github.maximkirko.wpserver.datamodel.Ticket;
import com.github.maximkirko.wpserver.datamodel.User;
import com.github.maximkirko.wpserver.datamodel.action.Action;
import com.github.maximkirko.wpserver.datamodel.action.ActionEnum;
import com.github.maximkirko.wpserver.datamodel.violation.Violation;
import com.github.maximkirko.wpserver.datamodel.violation.ViolationEnum;
import com.github.maximkirko.wpserver.datamodel.violation.impl.ParkingOnGrass;
import com.github.maximkirko.wpserver.service.api.IActionService;
import com.github.maximkirko.wpserver.service.api.IUserService;
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
    private TicketServiceImpl ticketService;

    @Test
    public void insertTest() {

        Ticket ticket = new Ticket();
        ticket.setDate(new Date());
        ticket.setLocation("loc");
        ticket.setLicensePlate("LP 1234");

        Action action = new Action();
        action.setType(ActionEnum.CallATowTrack);
        action.setDescription("desc");

        Violation violation = new Violation();
        violation.setType(ViolationEnum.ParkingAtBusStop);
        violation.setFee(50f);
        violation.setDescription("desc");
        Set<Action> actions = new HashSet<>(); //asdcfvgbnmasdfgvbjmswedrfgyhujmkwzexcrgtbjnmk!!!!!!!!!!!!!!!!!!
        actions.add(action);

        violation.setActions(actions);

        ticket.setViolation(violation);

        Photo photo = new Photo();
        photo.setPhoto(new byte[5]);

        Set<Photo> photoSet = new HashSet<>();
        photoSet.add(photo);

        ticket.setViolationPhotos(photoSet);

        ticketService.save(ticket);

//        User user = new User();
//        user.setLogin("maximkirko");
//        user.setPassword("qwerty");
//        user.setLoggedIn(false);
//
//        Role role = new Role();
//        role.setType("ADMIN");
//
//        user.setRole(role);
//
//        userService.save(user);

    }
}
