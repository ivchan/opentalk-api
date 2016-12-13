package opentalk.dao;

import opentalk.domainmodel.Channel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by Ivan Chan on 11/8/2016.
 */
@Repository
public interface ChannelRepository extends MongoRepository<Channel, UUID>, ChannelRepositoryCustom {
}
