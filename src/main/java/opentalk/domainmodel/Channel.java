package opentalk.domainmodel;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

/**
 * Created by ivanchan on 11/7/16.
 */

@Entity
@Table(name = "team_channel")
public class Channel extends BasePersistenceModel {
    @Id
    @Column(name = "channel_key")
    private UUID channelKey;
    @Column(name = "channel_name", length = 20, nullable = false)
    private String channelName;
    @Column(name = "channel_desc", length = 100)
    private String channelDescription;
    @Column(name = "is_public_channel")
    private boolean isPublicChannel;
    @Column(name = "status")
    private ChannelStatus status;
    @OneToMany(mappedBy = "channelKey")
    private Set<ChannelMember> channelMembers;

    public Channel() {
        this.channelKey = null;
        this.channelName = "";
        this.channelDescription = "";
        this.isPublicChannel = false;
        this.status = ChannelStatus.Active;
    }

    public Channel(UUID channelKey, String channelName, String channelDescription, boolean isPublicChannel, ChannelStatus status) {
        this.channelKey = channelKey;
        this.channelName = channelName;
        this.channelDescription = channelDescription;
        this.isPublicChannel = isPublicChannel;
        this.status = status;
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

    public ChannelStatus getStatus() {
        return status;
    }

    public void setStatus(ChannelStatus status) {
        this.status = status;
    }

    public Set<ChannelMember> getChannelMembers() {
        return channelMembers;
    }

    public void setChannelMembers(Set<ChannelMember> channelMembers) {
        this.channelMembers = channelMembers;
    }
}
