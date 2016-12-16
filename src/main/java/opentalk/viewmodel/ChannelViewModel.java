package opentalk.viewmodel;

/**
 * Created by ivanchan on 23/11/2016.
 */
public class ChannelViewModel {
    private String channelKey;
    private String channelName;
    private String channelDescription;
    private boolean isPublicChannel;

    public ChannelViewModel() {
        this.channelKey = null;
        this.channelName = "";
        this.isPublicChannel = false;
        this.channelDescription = "";
    }

    public String getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(String channelKey) {
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

    public String getChannelDescription() {
        return channelDescription;
    }

    public void setChannelDescription(String channelDescription) {
        this.channelDescription = channelDescription;
    }
}
