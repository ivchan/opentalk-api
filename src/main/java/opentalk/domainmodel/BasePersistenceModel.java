package opentalk.domainmodel;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by ivanchan on 7/11/2016.
 */

@MappedSuperclass
public abstract class BasePersistenceModel {
    @Column(name = "date_created")
    @CreationTimestamp
    protected Date dateCreated;

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
