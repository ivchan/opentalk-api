package opentalk.domainmodel;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by ivanchan on 11/7/16.
 */

@Document(collection = "team_channel")
public class Channel extends BasePersistenceModel {
    @Id
    @Field("channel_key")
    private UUID channelKey;
    @Field("channel_name")
    private String channelName;
    @Field("channel_desc")
    private String channelDescription;
    @Field("is_public_channel")
    private boolean isPublicChannel;

    public Channel() {
        this.channelKey = UUID.randomUUID();
        this.channelName = "";
        this.channelDescription = "";
        this.isPublicChannel = false;
    }

    public Channel(UUID channelKey, String channelName, String channelDescription, boolean isPublicChannel, ChannelStatus status) {
        this.channelKey = channelKey;
        this.channelName = channelName;
        this.channelDescription = channelDescription;
        this.isPublicChannel = isPublicChannel;
    }

    public UUID getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(UUID channelKey) {
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
