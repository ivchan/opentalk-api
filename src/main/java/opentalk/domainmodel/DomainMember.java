package opentalk.domainmodel;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by ivanchan on 7/11/2016.
 */
@Document(collection = "adm_domain_member")
public class DomainMember extends BasePersistenceModel implements Serializable{
    @Id
    @Field("domain_member_key")
    private UUID domainMemberKey;

    @Field("user_key")
    private UUID userKey;

    @Field("domain_key")
    private UUID domainKey;

    public UUID getDomainMemberKey() {
        return domainMemberKey;
    }

    public void setDomainMemberKey(UUID domainMemberKey) {
        this.domainMemberKey = domainMemberKey;
    }

    public UUID getUserKey() {
        return userKey;
    }

    public void setUserKey(UUID userKey) {
        this.userKey = userKey;
    }

    public UUID getDomainKey() {
        return domainKey;
    }

    public void setDomainKey(UUID domainKey) {
        this.domainKey = domainKey;
    }
}
