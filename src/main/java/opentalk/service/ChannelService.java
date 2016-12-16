package opentalk.service;

import opentalk.domainmodel.Channel;
import opentalk.domainmodel.ChannelMember;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Created by Ivan Chan on 11/9/2016.
 */
public interface ChannelService {
    void setChannelKey(ObjectId channelKey);
    ObjectId getChannelKey();
    Channel getChannel(ObjectId channelKey);
    List<Channel> listChannels();
    List<Channel> listPublicChannels();
    List<Channel> listPrivateChannels();
    Channel addChannel(Channel channel);
    Channel updateChannel(Channel channel);
    void deleteChannel(ObjectId channelKey);
    boolean isChannelExists(ObjectId channelKey);
    ChannelMember addChannelMember(ChannelMember channelMember);
    void removeChannelMember(ObjectId channelMemberKey);
    ChannelMember getChannelMember(ObjectId channelMemberKey);
    List<ChannelMember> listChannelMembers();
}
