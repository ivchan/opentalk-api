package opentalk.domainmodel;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by ivanchan on 7/11/2016.
 */

public abstract class Message extends BasePersistenceModel {
    @Id
    private ObjectId messageKey;
    @Field("parent_message")
    private ObjectId parentMessageKey;
    @Field("channel")
    private ObjectId channelKey;
    @Field("create_by")
    private ObjectId createBy;
    @Field("content")
    private String messageContent;

    public ObjectId getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(ObjectId messageKey) {
        this.messageKey = messageKey;
    }

    public ObjectId getParentMessageKey() {
        return parentMessageKey;
    }

    public void setParentMessageKey(ObjectId parentMessageKey) {
        this.parentMessageKey = parentMessageKey;
    }

    public ObjectId getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(ObjectId channelKey) {
        this.channelKey = channelKey;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public ObjectId getCreateBy() {
        return createBy;
    }

    public void setCreateBy(ObjectId createBy) {
        this.createBy = createBy;
    }
}
