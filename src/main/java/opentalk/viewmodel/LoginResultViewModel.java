package opentalk.viewmodel;

import java.util.Date;
import java.util.UUID;

/**
 * Created by ivanchan on 21/11/2016.
 */
public class LoginResultViewModel {
    private String loginResult;
    private UUID userKey;
    private String userID;
    private String userName;
    private Date loginTime;

    public LoginResultViewModel() {
        this.loginResult = "";
        this.userKey = new UUID(0, 0);
        this.userID = "";
        this.userName = "";
        this.loginTime = null;
    }

    public String getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(String loginResult) {
        this.loginResult = loginResult;
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

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
