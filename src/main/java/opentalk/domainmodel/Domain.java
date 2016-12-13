/**
 * Created by ivanchan on 3/11/2016.
 */

package opentalk.domainmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="adm_domain")
public class Domain extends BasePersistenceModel {
    @Id
    @Column(name = "domain_key", unique = true, nullable = false)
    private UUID domainKey;
    @Column(name = "domain_name", unique = true, nullable = false, length=20)
    private String domainName;
    @Column(name = "full_domain", unique = true, nullable = false, length = 100)
    private String fullDomain;

    public Domain() {
        this.domainKey = new UUID(0L, 0L);
        this.domainName = "";
        this.fullDomain = "";
    }

    public Domain(UUID domainKey, String domainName, String fullDomain) {
        this.domainKey = domainKey;
        this.domainName = domainName;
        this.fullDomain = fullDomain;
    }

    public UUID getDomainKey() {
        return domainKey;
    }

    public void setDomainKey(UUID domainKey) {
        this.domainKey = domainKey;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getFullDomain() {
        return fullDomain;
    }

    public void setFullDomain(String fullDomain) {
        this.fullDomain = fullDomain;
    }
}
