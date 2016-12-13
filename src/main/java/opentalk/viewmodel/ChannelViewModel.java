package opentalk.viewmodel;

import java.util.UUID;

/**
 * Created by ivanchan on 23/11/2016.
 */
public class ChannelViewModel {
    private UUID channelKey;
    private String channelName;
    private boolean isPublicChannel;
    private int channelStatus;

    public ChannelViewModel() {
        this.channelKey = null;
        this.channelName = "";
        this.isPublicChannel = false;
        this.channelStatus = 0;
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

    public boolean isPublicChannel() {
        return isPublicChannel;
    }

    public void setPublicChannel(boolean publicChannel) {
        isPublicChannel = publicChannel;
    }

    public int getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(int channelStatus) {
        this.channelStatus = channelStatus;
    }
}
