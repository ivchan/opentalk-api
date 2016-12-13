package opentalk.viewmodel;

import java.util.UUID;

/**
 * Created by ivanchan on 22/11/2016.
 */
public class UserViewModel {
    private UUID userKey;
    private String userID;
    private String userName;
    private String userEmail;

    public UserViewModel() {
        this.userKey = null;
        this.userID = "";
        this.userName = "";
        this.userEmail = "";
    }

    public UserViewModel(UUID userKey, String userID, String userName, String userEmail) {
        this.userKey = userKey;
        this.userID = userID;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public UUID getUserKey() {
        return userKey;
    }

    public void setUserKey(UUID userKey) {
        this.userKey = userKey;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
