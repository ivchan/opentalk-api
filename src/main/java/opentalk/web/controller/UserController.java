/**
 * Created by ivanchan on 4/11/2016.
 */

package opentalk.web.controller;

import opentalk.domainmodel.User;
import opentalk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController extends ApiController{
    @Autowired
    private UserService _userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listUsers() {
        List<User> lstUser = _userService.listUsers();
        return new ResponseEntity<>(lstUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id")UUID userKey) {
        if (!_userService.isUserExists(userKey)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user = _userService.getUser(userKey);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user) {
        if (_userService.isUserExists(user.getUserKey())) {
            return new ResponseEntity<>(user, HttpStatus.CONFLICT);
        }
        User savedUser = _userService.addUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if (!_userService.isUserExists(user.getUserKey())) {
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
        User savedUser = _userService.updateUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id")UUID userKey) {
        if (!_userService.isUserExists(userKey)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        _userService.deleteUser(userKey);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
