package com.github.maximkirko.wpserver.test;

import com.github.maximkirko.wpserver.datamodel.action.Action;
import com.github.maximkirko.wpserver.datamodel.action.ActionEnum;
import com.github.maximkirko.wpserver.service.api.IActionService;
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
public class ActionServiceTest {

    @Inject
    private IActionService actionService;

    @Test
    public void getByIdTest() {

        Action action = actionService.getById(1l);
        System.out.println(action);

        action = ActionEnum.getActionFromEnum(action.getType());
        action.performAction();

    }

//    @Test
//    @Ignore
//    public void insertTest() {
//
//        Action action = new Action();
//        action.setType(ActionEnum.CallATowTrack);
//        action.setDescription("YOUR CAR HAVE BEAN EVACUATED!");
//
//        actionService.save(action);
//    }

}
