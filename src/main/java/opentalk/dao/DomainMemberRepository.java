package opentalk.dao;

import opentalk.domainmodel.DomainMember;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

/**
 * Created by Ivan Chan on 11/8/2016.
 */
public interface DomainMemberRepository extends MongoRepository<DomainMember, UUID>, DomainMemberRepositoryCustom {
}
