/**
 * Created by ivanchan on 3/11/2016.
 */

package opentalk.service;

import opentalk.domainmodel.LoginModel;
import opentalk.domainmodel.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User getUser(UUID userKey);
    List<User> listUsers();
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(UUID userKey);
    boolean isUserExists(UUID userKey);
    UUID checkLogin(LoginModel loginModel);
}
