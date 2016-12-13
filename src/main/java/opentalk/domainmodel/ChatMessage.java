package opentalk.domainmodel;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ivan Chan on 11/8/2016.
 */

@Entity
@Table(name = "msg_chat_message")
public class ChatMessage extends Message {
}
