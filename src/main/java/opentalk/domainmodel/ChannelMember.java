package opentalk.domainmodel;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * Created by ivanchan on 11/7/16.
 */

@Document(collection = "team_channel_member")
public class ChannelMember extends BasePersistenceModel implements Serializable {
    @Id
    private ObjectId ChannelMemberKey;

    @Field("user_key")
    private ObjectId userKey;

    @Field("channel_key")
    private ObjectId channelKey;

    public ChannelMember() {
        ChannelMemberKey = new ObjectId();
        userKey = null;
        channelKey = null;
    }

    public ChannelMember(ObjectId channelMemberKey, ObjectId userKey, ObjectId channelKey) {
        ChannelMemberKey = channelMemberKey;
        this.userKey = userKey;
        this.channelKey = channelKey;
    }

    public ObjectId getChannelMemberKey() {
        return ChannelMemberKey;
    }

    public void setChannelMemberKey(ObjectId channelMemberKey) {
        ChannelMemberKey = channelMemberKey;
    }

    public ObjectId getUserKey() {
        return userKey;
    }

    public void setUserKey(ObjectId userKey) {
        this.userKey = userKey;
    }

    public ObjectId getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(ObjectId channelKey) {
        this.channelKey = channelKey;
    }
}
