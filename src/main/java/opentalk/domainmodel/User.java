/**
 * Created by ivanchan on 3/11/2016.
 */

package opentalk.domainmodel;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.util.*;

@Document(collection = "adm_user")
public class User extends BasePersistenceModel {
    @Id
    @Field("user_key")
    private UUID userKey;
    @Field("user_id")
    private String userID;
    @Field("user_name")
    private String userName;
    @Field("user_email")
    private String userEmail;

    public User() {
        this.userKey = UUID.randomUUID();
        this.userID = "";
        this.userName = "";
        this.userEmail = "";
    }

    public User(UUID userKey, String userID, String userName, String userEmail) {
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
