package opentalk.web.controller;

import opentalk.domainmodel.Channel;
import opentalk.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by Ivan Chan on 11/17/2016.
 */

@RestController
public class ChannelController extends ApiController{
    @Autowired
    private ChannelService _channelService;

    @RequestMapping(value = "/channel", method = RequestMethod.GET)
    public ResponseEntity<List<Channel>> listChannel() {
        List<Channel> listChannel = _channelService.listChannels();
        return new ResponseEntity<>(listChannel, HttpStatus.OK);
    }

    @RequestMapping(value = "/channel_public", method = RequestMethod.GET)
    public ResponseEntity<List<Channel>> listPublicChannel() {
        List<Channel> listChannel = _channelService.listPublicChannels();
        return new ResponseEntity<>(listChannel, HttpStatus.OK);
    }

    @RequestMapping(value = "/channel_private", method = RequestMethod.GET)
    public ResponseEntity<List<Channel>> listPrivateChannel() {
        List<Channel> listChannel = _channelService.listPrivateChannels();
        return new ResponseEntity<>(listChannel, HttpStatus.OK);
    }

    @RequestMapping(value = "/channel/{id}", method = RequestMethod.GET)
    public ResponseEntity<Channel> getChannel(@PathVariable("id")UUID channelKey) {
        if (!_channelService.isChannelExists(channelKey)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Channel channel = _channelService.getChannel(channelKey);
        return new ResponseEntity<>(channel, HttpStatus.OK);
    }

    @RequestMapping(value = "/channel", method = RequestMethod.POST)
    public ResponseEntity<Channel> addChannel(@RequestBody Channel channel) {
        if (_channelService.isChannelExists(channel.getChannelKey())) {
            return new ResponseEntity<>(channel, HttpStatus.CONFLICT);
        }
        Channel savedChannel = _channelService.addChannel(channel);
        return new ResponseEntity<>(savedChannel, HttpStatus.OK);
    }

    @RequestMapping(value = "/channel/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Channel> updateChannel(@PathVariable("id")UUID channelKey, @RequestBody Channel channel) {
        if (!_channelService.isChannelExists(channelKey)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Channel savedChannel = _channelService.updateChannel(channel);
        return new ResponseEntity<>(savedChannel, HttpStatus.OK);
    }

    @RequestMapping(value = "/channel/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteChannel(@PathVariable("id")UUID channelKey) {
        if (!_channelService.isChannelExists(channelKey)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        _channelService.deleteChannel(channelKey);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
