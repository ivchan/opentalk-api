package opentalk.viewmodel;

import org.bson.types.ObjectId;

import java.util.Date;

/**
 * Created by ivanchan on 29/11/2016.
 */
public class ChatMessageViewModel {
    private ObjectId messageKey;
    private ObjectId channelKey;
    private ObjectId userKey;
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

    public ChatMessageViewModel(ObjectId messageKey, ObjectId channelKey, ObjectId userKey, String userName, Date createDate, String content) {
        this.messageKey = messageKey;
        this.channelKey = channelKey;
        this.userKey = userKey;
        this.userName = userName;
        this.createDate = createDate;
        this.content = content;
    }

    public ObjectId getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(ObjectId messageKey) {
        this.messageKey = messageKey;
    }

    public ObjectId getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(ObjectId channelKey) {
        this.channelKey = channelKey;
    }

    public ObjectId getUserKey() {
        return userKey;
    }

    public void setUserKey(ObjectId userKey) {
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
