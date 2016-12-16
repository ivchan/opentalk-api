package opentalk.service;

import opentalk.dao.ChannelMemberRepository;
import opentalk.dao.ChannelRepository;
import opentalk.domainmodel.Channel;
import opentalk.domainmodel.ChannelMember;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan Chan on 11/9/2016.
 */
@Service("ChannelService")
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelRepository _channelRepository;
    @Autowired
    private ChannelMemberRepository _channelMemberRepository;

    private ObjectId _channelKey;

    public ChannelServiceImpl() {
        this._channelKey = null;
    }

    public ChannelServiceImpl(ObjectId channelKey) {
        this._channelKey = channelKey;
    }

    @Override
    public ObjectId getChannelKey() {
        return _channelKey;
    }

    @Override
    public void setChannelKey(ObjectId _channelKey) {
        this._channelKey = _channelKey;
    }

    @Override
    public Channel getChannel(ObjectId channelKey) {
        if (channelKey == null) {
            throw new IllegalArgumentException("Channel key should not be null");
        }
        return _channelRepository.findOne(channelKey);
    }

    @Override
    public List<Channel> listChannels() {
        return (List<Channel>)_channelRepository.findAll();
    }

    @Override
    public List<Channel> listPublicChannels() {
        return (List<Channel>)_channelRepository.findPublicChannels();
    }

    @Override
    public List<Channel> listPrivateChannels() {
        return (List<Channel>)_channelRepository.findPrivateChannels();
    }

    @Override
    public Channel addChannel(Channel channel) {
        if (channel.getChannelKey() == null){
            channel.setChannelKey(new ObjectId());
        }
        _channelRepository.save(channel);
        return channel;
    }

    @Override
    public Channel updateChannel(Channel channel) {
        if (_channelRepository.findOne(channel.getChannelKey()) == null) {
            throw new IllegalArgumentException("Channel Key does not found");
        }
        _channelRepository.save(channel);
        return channel;
    }

    @Override
    public void deleteChannel(ObjectId channelKey) {
        if (getChannel(channelKey) == null) {
            throw new IllegalArgumentException("Channel Key does not found");
        }
        _channelRepository.delete(channelKey);
    }

    @Override
    public boolean isChannelExists(ObjectId channelKey) {
        return (_channelRepository.findOne(channelKey) == null) ? false : true;
    }

    @Override
    public ChannelMember addChannelMember(ChannelMember channelMember) {
        if (this._channelKey == null) {
            throw new IllegalArgumentException("Channel key should not be empty");
        }
        if (channelMember.getChannelKey() == null){
            channelMember.setChannelKey(this._channelKey);
        }
        if (channelMember.getChannelMemberKey() == null){
            channelMember.setChannelMemberKey(new ObjectId());
        }
        _channelMemberRepository.save(channelMember);
        return channelMember;
    }

    @Override
    public void removeChannelMember(ObjectId channelMemberKey) {
        if (this._channelKey == null) {
            throw new IllegalArgumentException("Channel key should not be empty");
        }
        _channelMemberRepository.delete(channelMemberKey);
    }

    @Override
    public ChannelMember getChannelMember(ObjectId channelMemberKey) {
        if (this._channelKey == null) {
            throw new IllegalArgumentException("Channel key should not be empty");
        }
        return _channelMemberRepository.findOne(channelMemberKey);
    }

    @Override
    public List<ChannelMember> listChannelMembers() {
        if (this._channelKey == null) {
            throw new IllegalArgumentException("Channel key should not be empty");
        }
        //return (List<ChannelMember>)_channelMemberRepository.listMembers(_channelKey);
        return null;
    }
}
