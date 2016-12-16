package opentalk.web.controller;

import opentalk.domainmodel.LoginModel;
import opentalk.domainmodel.User;
import opentalk.service.UserService;
import opentalk.viewmodel.LoginResultViewModel;
import opentalk.viewmodel.LoginViewModel;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by ivanchan on 21/11/2016.
 */

@RestController
public class UserLoginController extends ApiController {
    @Autowired
    private UserService _userService;

    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public ResponseEntity<LoginResultViewModel> CheckLogin(@RequestBody LoginViewModel loginVM) {
        if (loginVM == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LoginModel loginModel = new LoginModel(loginVM.getLoginName(), loginVM.getLoginPassword());
        ObjectId userKey = _userService.checkLogin(loginModel);
        if (userKey == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            User loggedUser = _userService.getUser(userKey);
            LoginResultViewModel result = new LoginResultViewModel();
            result.setUserKey(loggedUser.getUserKey());
            result.setUserName(loggedUser.getUserName());
            result.setUserID(loggedUser.getUserID());
            result.setLoginResult("Success");
            result.setLoginTime(new Date());
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}
