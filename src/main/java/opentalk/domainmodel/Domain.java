/**
 * Created by ivanchan on 3/11/2016.
 */

package opentalk.domainmodel;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "adm_domain")
public class Domain extends BasePersistenceModel {
    @Id
    private ObjectId domainKey;
    @Field("domain_name")
    private String domainName;
    @Field("full_domain")
    private String fullDomain;

    public Domain() {
        this.domainKey = new ObjectId();
        this.domainName = "";
        this.fullDomain = "";
    }

    public Domain(ObjectId domainKey, String domainName, String fullDomain) {
        this.domainKey = domainKey;
        this.domainName = domainName;
        this.fullDomain = fullDomain;
    }

    public ObjectId getDomainKey() {
        return domainKey;
    }

    public void setDomainKey(ObjectId domainKey) {
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
