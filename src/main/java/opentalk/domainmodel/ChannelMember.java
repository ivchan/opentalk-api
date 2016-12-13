package opentalk.domainmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by ivanchan on 11/7/16.
 */

@Entity
@Table(name = "team_channel_member")
public class ChannelMember extends BasePersistenceModel implements Serializable {
    @Id
    @Column(name = "channel_member_key")
    private UUID ChannelMemberKey;

    @Column(name = "user_key")
    private UUID userKey;

    @Column(name = "channel_key")
    private UUID channelKey;

    public ChannelMember() {
        ChannelMemberKey = null;
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
