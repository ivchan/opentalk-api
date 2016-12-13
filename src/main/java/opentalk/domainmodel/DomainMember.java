package opentalk.domainmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by ivanchan on 7/11/2016.
 */
@Entity
@Table(name = "adm_domain_member")
public class DomainMember extends BasePersistenceModel implements Serializable{
    @Id
    @Column(name = "domain_member_key")
    private UUID domainMemberKey;

    @Column(name = "user_key")
    private UUID userKey;

    @Column(name = "domain_key")
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
