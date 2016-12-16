package opentalk.domainmodel;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by ivanchan on 11/7/16.
 */

@Document(collection = "team_channel")
public class Channel extends BasePersistenceModel {
    @Id
    private ObjectId channelKey;
    @Field("channel_name")
    private String channelName;
    @Field("channel_desc")
    private String channelDescription;
    @Field("is_public_channel")
    private boolean isPublicChannel;

    public Channel() {
        this.channelKey = new ObjectId();
        this.channelName = "";
        this.channelDescription = "";
        this.isPublicChannel = false;
    }

    public Channel(ObjectId channelKey, String channelName, String channelDescription, boolean isPublicChannel, ChannelStatus status) {
        this.channelKey = channelKey;
        this.channelName = channelName;
        this.channelDescription = channelDescription;
        this.isPublicChannel = isPublicChannel;
    }

    public ObjectId getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(ObjectId channelKey) {
        this.channelKey = channelKey;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelDescription() {
        return channelDescription;
    }

    public void setChannelDescription(String channelDescription) {
        this.channelDescription = channelDescription;
    }

    public boolean isPublicChannel() {
        return isPublicChannel;
    }

    public void setPublicChannel(boolean publicChannel) {
        isPublicChannel = publicChannel;
    }
}
