package opentalk.viewmodel;

import java.util.Date;
import java.util.UUID;

/**
 * Created by ivanchan on 29/11/2016.
 */
public class ChatMessageViewModel {
    private UUID messageKey;
    private UUID channelKey;
    private UUID userKey;
    private String userName;
    private Date createDate;
    private String content;

    public ChatMessageViewModel() {
        this.messageKey = null;
        this.channelKey = null;
        this.userKey = null;
        this.content = "";
        this.userName = "";
        this.createDate = new Date();
    }

    public ChatMessageViewModel(UUID messageKey, UUID channelKey, UUID userKey, String userName, Date createDate, String content) {
        this.messageKey = messageKey;
        this.channelKey = channelKey;
        this.userKey = userKey;
        this.userName = userName;
        this.createDate = createDate;
        this.content = content;
    }

    public UUID getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(UUID messageKey) {
        this.messageKey = messageKey;
    }

    public UUID getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(UUID channelKey) {
        this.channelKey = channelKey;
    }

    public UUID getUserKey() {
        return userKey;
    }

    public void setUserKey(UUID userKey) {
        this.userKey = userKey;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
