package com.github.maximkirko.wpserver.test;

import com.github.maximkirko.wpserver.datamodel.User;
import com.github.maximkirko.wpserver.service.api.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by MadMax on 27.11.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app_context.xml")
public class UserServiceTest {

    @Inject
    private IUserService userService;

    @Test
    public void getByIdTest() {

        User user = userService.getById(2l);
        System.out.println(user);
    }
}
