/**
 * Created by ivanchan on 4/11/2016.
 */

package opentalk.web.controller;

import opentalk.domainmodel.User;
import opentalk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class InitialDBController {
    @Autowired
    private UserService _userService;

    @RequestMapping(value = "/initialdb", method = RequestMethod.POST)
    public void initialize() {
        User userIvan = new User();
        userIvan.setUserKey(UUID.randomUUID());
        userIvan.setUserName("Ivan Chan");
        userIvan.setUserEmail("29january@gmail.com");

        User userRay = new User();
        userRay.setUserKey(UUID.randomUUID());
        userRay.setUserName("Ray Chung");
        userRay.setUserEmail("ray@gmail.com");

        User userJoseph = new User();
        userJoseph.setUserKey(UUID.randomUUID());
        userJoseph.setUserName("Joseph Ting");
        userJoseph.setUserEmail("jjting@gmail.com");

        User userKing = new User();
        userKing.setUserKey(UUID.randomUUID());
        userKing.setUserName("King Chau");
        userKing.setUserEmail("king@gmail.com");

        User userBless = new User();
        userBless.setUserKey(UUID.randomUUID());
        userBless.setUserName("Bless Lei");
        userBless.setUserEmail("bless@gmail.com");

        User userCherrie = new User();
        userCherrie.setUserKey(UUID.randomUUID());
        userCherrie.setUserName("Cherrie Chan");
        userCherrie.setUserEmail("cherrie@gmail.com");

        _userService.addUser(userIvan);
        _userService.addUser(userBless);
        _userService.addUser(userCherrie);
        _userService.addUser(userRay);
        _userService.addUser(userKing);
        _userService.addUser(userJoseph);
    }
}
