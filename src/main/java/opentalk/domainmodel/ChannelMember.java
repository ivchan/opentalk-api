package opentalk.domainmodel;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by ivanchan on 11/7/16.
 */

@Document(collection = "team_channel_member")
public class ChannelMember extends BasePersistenceModel implements Serializable {
    @Id
    @Field("channel_member_key")
    private UUID ChannelMemberKey;

    @Field("user_key")
    private UUID userKey;

    @Field("channel_key")
    private UUID channelKey;

    public ChannelMember() {
        ChannelMemberKey = UUID.randomUUID();
        userKey = null;
        channelKey = null;
    }

    public ChannelMember(UUID channelMemberKey, UUID userKey, UUID channelKey) {
        ChannelMemberKey = channelMemberKey;
        this.userKey = userKey;
        this.channelKey = channelKey;
    }

    public UUID getChannelMemberKey() {
        return ChannelMemberKey;
    }

    public void setChannelMemberKey(UUID channelMemberKey) {
        ChannelMemberKey = channelMemberKey;
    }

    public UUID getUserKey() {
        return userKey;
    }

    public void setUserKey(UUID userKey) {
        this.userKey = userKey;
    }

    public UUID getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(UUID channelKey) {
        this.channelKey = channelKey;
    }
}
