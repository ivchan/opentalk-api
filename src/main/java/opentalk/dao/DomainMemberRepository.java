package opentalk.dao;

import opentalk.domainmodel.DomainMember;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by Ivan Chan on 11/8/2016.
 */
public interface DomainMemberRepository extends CrudRepository<DomainMember, UUID>, DomainMemberRepositoryCustom {
}
