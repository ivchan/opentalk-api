package opentalk.domainmodel;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by ivanchan on 7/11/2016.
 */

@MappedSuperclass
public abstract class Message extends BasePersistenceModel {
    @Id
    @Field("message_id")
    private UUID messageKey;
    @Field("parent_message")
    private UUID parentMessageKey;
    @Field("channel")
    private UUID channelKey;
    @Field("create_by")
    private UUID createBy;
    @Field("content")
    private String messageContent;

    public UUID getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(UUID messageKey) {
        this.messageKey = messageKey;
    }

    public UUID getParentMessageKey() {
        return parentMessageKey;
    }

    public void setParentMessageKey(UUID parentMessageKey) {
        this.parentMessageKey = parentMessageKey;
    }

    public UUID getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(UUID channelKey) {
        this.channelKey = channelKey;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public UUID getCreateBy() {
        return createBy;
    }

    public void setCreateBy(UUID createBy) {
        this.createBy = createBy;
    }
}
