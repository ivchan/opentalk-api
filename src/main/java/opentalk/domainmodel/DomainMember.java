package opentalk.domainmodel;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * Created by ivanchan on 7/11/2016.
 */
@Document(collection = "adm_domain_member")
public class DomainMember extends BasePersistenceModel implements Serializable{
    @Id
    private ObjectId domainMemberKey;

    @Field("user_key")
    private ObjectId userKey;

    @Field("domain_key")
    private ObjectId domainKey;

    public ObjectId getDomainMemberKey() {
        return domainMemberKey;
    }

    public void setDomainMemberKey(ObjectId domainMemberKey) {
        this.domainMemberKey = domainMemberKey;
    }

    public ObjectId getUserKey() {
        return userKey;
    }

    public void setUserKey(ObjectId userKey) {
        this.userKey = userKey;
    }

    public ObjectId getDomainKey() {
        return domainKey;
    }

    public void setDomainKey(ObjectId domainKey) {
        this.domainKey = domainKey;
    }
}
