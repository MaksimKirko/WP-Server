package com.github.maximkirko.wpserver.test;

import com.github.maximkirko.wpserver.datamodel.action.Action;
import com.github.maximkirko.wpserver.datamodel.action.ActionEnum;
import com.github.maximkirko.wpserver.datamodel.violation.Violation;
import com.github.maximkirko.wpserver.datamodel.violation.ViolationEnum;
import com.github.maximkirko.wpserver.service.api.IActionService;
import com.github.maximkirko.wpserver.service.api.IViolationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by MadMax on 28.11.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app_context.xml")
public class ViolationServiceTest {

    @Inject
    private IViolationService violationService;

//    @Test
//    public void getByIdTest() {
//
//        Action action = actionService.getById(1l);
//        System.out.println(action);
//
//        action = ActionEnum.getActionFromEnum(action.getType());
//        action.performAction();
//
//    }

    @Test
    public void insertTest() {

        Violation violation = new Violation();
        violation.setType(ViolationEnum.ParkingAtBusStop);
        violation.setDescription("PARKING AT BUS STOP");
        violation.setFee(50);

        Action action = new Action();
        action.setType(ActionEnum.WheelsBlock);
        action.setDescription("WHEELS ON YOUR CAR WERE BLOCKED!");

        violation.setAction(action);

        violationService.save(violation);
    }
}
