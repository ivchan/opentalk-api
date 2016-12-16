/**
 * Created by ivanchan on 4/11/2016.
 */

package opentalk.web.controller;

import opentalk.domainmodel.Channel;
import opentalk.domainmodel.User;
import opentalk.service.ChannelService;
import opentalk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialDBController {
    @Autowired
    private UserService _userService;
    @Autowired
    private ChannelService _channelService;


    @RequestMapping(value = "/initialdb", method = RequestMethod.POST)
    public void initialize() {
        User userIvan = new User();
        userIvan.setUserName("Ivan Chan");
        userIvan.setUserID("ivanchan");
        userIvan.setUserEmail("29january@gmail.com");

        User userRay = new User();
        userRay.setUserName("Ray Chung");
        userRay.setUserID("raychung");
        userRay.setUserEmail("ray@gmail.com");

        User userJoseph = new User();
        userJoseph.setUserName("Joseph Ting");
        userJoseph.setUserID("josephting");
        userJoseph.setUserEmail("jjting@gmail.com");

        User userKing = new User();
        userKing.setUserName("King Chau");
        userKing.setUserID("kingchau");
        userKing.setUserEmail("king@gmail.com");

        User userBless = new User();
        userBless.setUserName("Bless Lei");
        userBless.setUserID("blesslei");
        userBless.setUserEmail("bless@gmail.com");

        User userCherrie = new User();
        userCherrie.setUserName("Cherrie Chan");
        userCherrie.setUserID("cherriechan");
        userCherrie.setUserEmail("cherrie@gmail.com");

        _userService.addUser(userIvan);
        _userService.addUser(userBless);
        _userService.addUser(userCherrie);
        _userService.addUser(userRay);
        _userService.addUser(userKing);
        _userService.addUser(userJoseph);

        Channel channelA = new Channel();
        channelA.setChannelName("general");
        channelA.setChannelDescription("talk everything");
        channelA.setPublicChannel(true);

        Channel channelB = new Channel();
        channelB.setChannelName("dev");
        channelB.setChannelDescription("development life");
        channelB.setPublicChannel(true);

        Channel channelC = new Channel();
        channelC.setChannelName("secret");
        channelC.setChannelDescription("best own secret");
        channelC.setPublicChannel(false);

        _channelService.addChannel(channelA);
        _channelService.addChannel(channelB);
        _channelService.addChannel(channelC);
    }
}
