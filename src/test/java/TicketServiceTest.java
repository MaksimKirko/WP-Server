import com.github.maximkirko.wpserver.datamodel.Photo;
import com.github.maximkirko.wpserver.datamodel.Ticket;
import com.github.maximkirko.wpserver.datamodel.action.Action;
import com.github.maximkirko.wpserver.datamodel.action.ActionEnum;
import com.github.maximkirko.wpserver.datamodel.violation.Violation;
import com.github.maximkirko.wpserver.datamodel.violation.ViolationEnum;
import com.github.maximkirko.wpserver.service.api.ITicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.access.method.P;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Max on 29.11.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app_context.xml")
public class TicketServiceTest {

    @Inject
    private ITicketService ticketService;

    @Test
    public void saveTest() {

        Ticket ticket = new Ticket();
        ticket.setLicensePlate("LP 1654");
        ticket.setAddress("KOSMONAVTOV");
        ticket.setDate(new Date());
        ticket.setLocation("0.000, 0.000");

        Violation violation = new Violation();
        violation.setType(ViolationEnum.ParkingNearShop);
        violation.setDescription("PARKING NEAR SHOP");
        violation.setFee(50);

        Action action = new Action();
        action.setType(ActionEnum.AssignFee);
        action.setDescription("GIVE YOUR MONEY!");

        violation.setAction(action);

        ticket.setViolation(violation);

        Photo photo = new Photo();
        photo.setPhoto(new byte[5]);

        Set<Photo> phs = new HashSet<>();
        phs.add(photo);

        ticket.setViolationPhotos(phs);

        ticketService.save(ticket);

    }

}
