package opentalk.domainmodel;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Ivan Chan on 11/8/2016.
 */

@Document(collection = "msg_chat_message")
public class ChatMessage extends Message {
}
