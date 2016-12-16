package opentalk.domainmodel;

import org.bson.types.ObjectId;

/**
 * Created by ivanchan on 21/11/2016.
 */
public class LoginModel extends BaseDomainModel {
    private String loginName;
    private String loginPassword;
    private ObjectId userKey;

    public LoginModel() {
        this.loginName = "";
        this.loginPassword= "";
        this.userKey = null;
    }

    public LoginModel(String loginName, String loginPassword) {
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.userKey = null;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public ObjectId getUserKey() {
        return userKey;
    }

    public void setUserKey(ObjectId userKey) {
        this.userKey = userKey;
    }
}
