package opentalk.service;

import opentalk.dao.ChannelMemberRepository;
import opentalk.dao.ChannelRepository;
import opentalk.domainmodel.Channel;
import opentalk.domainmodel.ChannelMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Ivan Chan on 11/9/2016.
 */
@Service("ChannelService")
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelRepository _channelRepository;
    @Autowired
    private ChannelMemberRepository _channelMemberRepository;

    private UUID _channelKey;

    public ChannelServiceImpl() {
        this._channelKey = null;
    }

    public ChannelServiceImpl(UUID channelKey) {
        this._channelKey = channelKey;
    }

    @Override
    public UUID getChannelKey() {
        return _channelKey;
    }

    @Override
    public void setChannelKey(UUID _channelKey) {
        this._channelKey = _channelKey;
    }

    @Override
    public Channel getChannel(UUID channelKey) {
        if (channelKey == null) {
            throw new IllegalArgumentException("Channel key should not be null");
        }
        if (channelKey.equals(new UUID(0, 0))) {
            throw new IllegalArgumentException("Channel key should not be empty");
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
            channel.setChannelKey(UUID.randomUUID());
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
    public void deleteChannel(UUID channelKey) {
        if (getChannel(channelKey) == null) {
            throw new IllegalArgumentException("Channel Key does not found");
        }
        _channelRepository.delete(channelKey);
    }

    @Override
    public boolean isChannelExists(UUID channelKey) {
        return (_channelRepository.findOne(channelKey) == null) ? false : true;
    }

    @Override
    public ChannelMember addChannelMember(ChannelMember channelMember) {
        if ((this._channelKey == null) || (this._channelKey.equals(new UUID(0, 0)))) {
            throw new IllegalArgumentException("Channel key should not be empty");
        }
        if ((channelMember.getChannelKey() == null) || (channelMember.getChannelKey().equals(new UUID(0, 0)))){
            channelMember.setChannelKey(this._channelKey);
        }
        if ((channelMember.getChannelMemberKey() == null) || (channelMember.getChannelMemberKey().equals(new UUID(0, 0)))){
            channelMember.setChannelMemberKey(UUID.randomUUID());
        }
        _channelMemberRepository.save(channelMember);
        return channelMember;
    }

    @Override
    public void removeChannelMember(UUID channelMemberKey) {
        if ((this._channelKey == null) || (this._channelKey.equals(new UUID(0, 0)))) {
            throw new IllegalArgumentException("Channel key should not be empty");
        }
        _channelMemberRepository.delete(channelMemberKey);
    }

    @Override
    public ChannelMember getChannelMember(UUID channelMemberKey) {
        if ((this._channelKey == null) || (this._channelKey.equals(new UUID(0, 0)))) {
            throw new IllegalArgumentException("Channel key should not be empty");
        }
        return _channelMemberRepository.findOne(channelMemberKey);
    }

    @Override
    public List<ChannelMember> listChannelMembers() {
        if ((this._channelKey == null) || (this._channelKey.equals(new UUID(0, 0)))) {
            throw new IllegalArgumentException("Channel key should not be empty");
        }
        return (List<ChannelMember>)_channelMemberRepository.listMembers(_channelKey);
    }
}
