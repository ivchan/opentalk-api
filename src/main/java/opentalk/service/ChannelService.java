package opentalk.service;

import opentalk.domainmodel.Channel;
import opentalk.domainmodel.ChannelMember;

import java.util.List;
import java.util.UUID;

/**
 * Created by Ivan Chan on 11/9/2016.
 */
public interface ChannelService {
    void setChannelKey(UUID channelKey);
    UUID getChannelKey();
    Channel getChannel(UUID channelKey);
    List<Channel> listChannels();
    List<Channel> listPublicChannels();
    List<Channel> listPrivateChannels();
    Channel addChannel(Channel channel);
    Channel updateChannel(Channel channel);
    void deleteChannel(UUID channelKey);
    boolean isChannelExists(UUID channelKey);
    ChannelMember addChannelMember(ChannelMember channelMember);
    void removeChannelMember(UUID channelMemberKey);
    ChannelMember getChannelMember(UUID channelMemberKey);
    List<ChannelMember> listChannelMembers();
}
