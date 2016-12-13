package opentalk.dao;

import opentalk.domainmodel.ChannelMember;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by Ivan Chan on 11/8/2016.
 */

@Repository
public interface ChannelMemberRepository extends MongoRepository<ChannelMember, UUID>, ChannelMemberRepositoryCustom {
}
