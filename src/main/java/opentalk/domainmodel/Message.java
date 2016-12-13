package opentalk.domainmodel;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by ivanchan on 7/11/2016.
 */

@MappedSuperclass
public abstract class Message extends BasePersistenceModel {
    @Id
    @Column(name = "message_id")
    private UUID messageKey;
    @Column(name = "parent_message", nullable = true)
    private UUID parentMessageKey;
    @Column(name = "channel", nullable = false)
    private UUID channelKey;
    @Column(name = "create_by", nullable = false)
    private UUID createBy;
    @Column(name = "content", nullable = true, length = 255)
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
