/**
 * Created by ivanchan on 3/11/2016.
 */

package opentalk.domainmodel;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "adm_user")
public class User extends BasePersistenceModel {
    @Id
    @Column(name = "user_key")
    private UUID userKey;
    @Column(name = "user_id", nullable =  false, length = 20)
    private String userID;
    @Column(name = "user_name", nullable = false, length = 100)
    private String userName;
    @Column(name = "user_email", nullable = false, length = 100)
    private String userEmail;
    @OneToMany(mappedBy = "userKey", cascade = CascadeType.ALL)
    public Set<ChannelMember> channelMember;
    @OneToMany(mappedBy = "userKey", cascade = CascadeType.ALL)
    public Set<DomainMember> domainMember;

    public User() {
        this.userKey = new UUID(0L, 0L);
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

    public Set<ChannelMember> getChannelMember() {
        return channelMember;
    }

    public void setChannelMember(Set<ChannelMember> channelMember) {
        this.channelMember = channelMember;
    }

    public Set<DomainMember> getDomainMember() {
        return domainMember;
    }

    public void setDomainMember(Set<DomainMember> domainMember) {
        this.domainMember = domainMember;
    }
}
