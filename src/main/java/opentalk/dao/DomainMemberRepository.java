package opentalk.dao;

import opentalk.domainmodel.DomainMember;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Ivan Chan on 11/8/2016.
 */
public interface DomainMemberRepository extends MongoRepository<DomainMember, ObjectId>, DomainMemberRepositoryCustom {
}
