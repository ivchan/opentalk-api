package opentalk.web.controller;

import opentalk.domainmodel.Channel;
import opentalk.service.ChannelService;
import opentalk.viewmodel.ChannelViewModel;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan Chan on 11/17/2016.
 */

@RestController
public class ChannelController extends ApiController{
    @Autowired
    private ChannelService _channelService;

    @RequestMapping(value = "/channel", method = RequestMethod.GET)
    public ResponseEntity<List<ChannelViewModel>> listChannel() {
        List<Channel> listChannel = _channelService.listChannels();
        List<ChannelViewModel> listViewModel = new ArrayList<>();
        listChannel.forEach(channel -> {
           ChannelViewModel vm = new ChannelViewModel();
           vm.setChannelKey(channel.getChannelKey().toString());
           vm.setChannelName(channel.getChannelName());
           vm.setChannelDescription(channel.getChannelDescription());
           vm.setPublicChannel(channel.isPublicChannel());
           listViewModel.add(vm);
        });
        return new ResponseEntity<>(listViewModel, HttpStatus.OK);
    }

    @RequestMapping(value = "/channel_public", method = RequestMethod.GET)
    public ResponseEntity<List<ChannelViewModel>> listPublicChannel() {
        List<Channel> listChannel = _channelService.listPublicChannels();
        List<ChannelViewModel> listViewModel = new ArrayList<>();
        listChannel.forEach(channel -> {
            ChannelViewModel vm = new ChannelViewModel();
            vm.setChannelKey(channel.getChannelKey().toString());
            vm.setChannelName(channel.getChannelName());
            vm.setChannelDescription(channel.getChannelDescription());
            vm.setPublicChannel(channel.isPublicChannel());
            listViewModel.add(vm);
        });
        return new ResponseEntity<>(listViewModel, HttpStatus.OK);
    }

    @RequestMapping(value = "/channel_private", method = RequestMethod.GET)
    public ResponseEntity<List<ChannelViewModel>> listPrivateChannel() {
        List<Channel> listChannel = _channelService.listPrivateChannels();
        List<ChannelViewModel> listViewModel = new ArrayList<>();
        listChannel.forEach(channel -> {
            ChannelViewModel vm = new ChannelViewModel();
            vm.setChannelKey(channel.getChannelKey().toString());
            vm.setChannelName(channel.getChannelName());
            vm.setChannelDescription(channel.getChannelDescription());
            vm.setPublicChannel(channel.isPublicChannel());
            listViewModel.add(vm);
        });
        return new ResponseEntity<>(listViewModel, HttpStatus.OK);
    }

    @RequestMapping(value = "/channel/{id}", method = RequestMethod.GET)
    public ResponseEntity<Channel> getChannel(@PathVariable("id")ObjectId channelKey) {
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
    public ResponseEntity<Channel> updateChannel(@PathVariable("id")ObjectId channelKey, @RequestBody Channel channel) {
        if (!_channelService.isChannelExists(channelKey)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Channel savedChannel = _channelService.updateChannel(channel);
        return new ResponseEntity<>(savedChannel, HttpStatus.OK);
    }

    @RequestMapping(value = "/channel/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteChannel(@PathVariable("id")ObjectId channelKey) {
        if (!_channelService.isChannelExists(channelKey)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        _channelService.deleteChannel(channelKey);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
