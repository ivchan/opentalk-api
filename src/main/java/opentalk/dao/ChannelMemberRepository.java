package opentalk.dao;

import opentalk.domainmodel.ChannelMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by Ivan Chan on 11/8/2016.
 */

@Repository
public interface ChannelMemberRepository extends CrudRepository<ChannelMember, UUID>, ChannelMemberRepositoryCustom {
}
