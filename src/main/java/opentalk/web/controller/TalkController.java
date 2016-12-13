package opentalk.web.controller;

import opentalk.domainmodel.ChatMessage;
import opentalk.service.TalkService;
import opentalk.viewmodel.ChatMessageViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ivanchan on 29/11/2016.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TalkController extends ApiController {
    @Autowired
    private TalkService talkService;

    //@RequestMapping(value = "/talk", method = RequestMethod.POST)
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ChatMessageViewModel addChannel(ChatMessageViewModel chatMessage) {
        ChatMessage chatMsg = new ChatMessage();
        chatMsg.setMessageKey(chatMessage.getMessageKey());
        chatMsg.setChannelKey(chatMessage.getChannelKey());
        chatMsg.setParentMessageKey(null);
        chatMsg.setCreateBy(chatMessage.getUserKey());
        chatMsg.setMessageContent(chatMessage.getContent());

        ChatMessage savedMessage = talkService.addMessage(chatMsg);

        ChatMessageViewModel savedViewModel = new ChatMessageViewModel(savedMessage.getMessageKey(), savedMessage.getChannelKey(), savedMessage.getCreateBy(), "Anonymous", savedMessage.getDateCreated(), savedMessage.getMessageContent());
        return savedViewModel;
    }
}
