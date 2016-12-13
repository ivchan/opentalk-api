/**
 * Created by ivanchan on 3/11/2016.
 */

package opentalk.domainmodel;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.UUID;

@Document(collection = "adm_domain")
public class Domain extends BasePersistenceModel {
    @Id
    @Field("domain_key")
    private UUID domainKey;
    @Field("domain_name")
    private String domainName;
    @Field("full_domain")
    private String fullDomain;

    public Domain() {
        this.domainKey = UUID.randomUUID();
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
