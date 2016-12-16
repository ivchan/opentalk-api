/**
 * Created by ivanchan on 3/11/2016.
 */

package opentalk.service;

import opentalk.domainmodel.LoginModel;
import opentalk.domainmodel.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {
    User getUser(ObjectId userKey);
    List<User> listUsers();
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(ObjectId userKey);
    boolean isUserExists(ObjectId userKey);
    ObjectId checkLogin(LoginModel loginModel);
}
