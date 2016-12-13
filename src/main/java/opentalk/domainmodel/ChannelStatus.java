package opentalk.domainmodel;

/**
 * Created by Ivan Chan on 11/15/2016.
 */
public enum ChannelStatus {
    Inactive(0),
    Active(1);

    private final int value;

    private ChannelStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
