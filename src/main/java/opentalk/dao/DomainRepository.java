package opentalk.dao;

import opentalk.domainmodel.Domain;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ivan Chan on 11/8/2016.
 */
@Repository
public interface DomainRepository extends MongoRepository<Domain, ObjectId>, DomainRepositoryCustom {
}