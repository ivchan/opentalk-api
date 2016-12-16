/**
 * Created by ivanchan on 4/11/2016.
 */

package opentalk.service;

import opentalk.dao.UserRepository;
import opentalk.domainmodel.LoginModel;
import opentalk.domainmodel.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository _userRepository;

    @Override
    public User getUser(ObjectId userKey) {
        if (userKey == null) {
            throw new IllegalArgumentException("User key should not be null");
        }
        return _userRepository.findOne(userKey);
    }

    @Override
    public List<User> listUsers() {
        return (List<User>)_userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        User result = _userRepository.save(user);
        return result;
    }

    @Override
    public User updateUser(User user) {
        User result = _userRepository.save(user);
        return result;
    }

    @Override
    public void deleteUser(ObjectId userKey) {
        _userRepository.delete(userKey);
    }

    @Override
    public boolean isUserExists(ObjectId userKey) {
        return (_userRepository.findOne(userKey) != null ? true : false);
    }

    @Override
    public ObjectId checkLogin(LoginModel loginModel) {
        //User userLogin = _userRepository.findOne(loginModel.getLoginName());
        //return (userLogin != null) ? userLogin.getUserKey() : null;
        return null;
    }
}
