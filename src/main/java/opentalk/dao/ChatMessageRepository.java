package opentalk.dao;

import opentalk.domainmodel.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

/**
 * Created by Ivan Chan on 11/8/2016.
 */
public interface ChatMessageRepository extends MongoRepository<ChatMessage, UUID>, ChatMessageRepositoryCustom {
}
