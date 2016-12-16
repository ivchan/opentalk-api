package opentalk.dao;

import opentalk.domainmodel.ChatMessage;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Ivan Chan on 11/8/2016.
 */
public interface ChatMessageRepository extends MongoRepository<ChatMessage, ObjectId>, ChatMessageRepositoryCustom {
}
