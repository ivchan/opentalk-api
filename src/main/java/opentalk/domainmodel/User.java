/**
 * Created by ivanchan on 3/11/2016.
 */

package opentalk.domainmodel;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "adm_user")
public class User extends BasePersistenceModel {
    @Id
    private ObjectId userKey;
    @Field("user_id")
    private String userID;
    @Field("user_name")
    private String userName;
    @Field("user_email")
    private String userEmail;

    public User() {
        this.userKey = new ObjectId();
        this.userID = "";
        this.userName = "";
        this.userEmail = "";
    }

    public User(ObjectId userKey, String userID, String userName, String userEmail) {
        this.userKey = userKey;
        this.userID = userID;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public ObjectId getUserKey() {
        return userKey;
    }

    public void setUserKey(ObjectId userKey) {
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
