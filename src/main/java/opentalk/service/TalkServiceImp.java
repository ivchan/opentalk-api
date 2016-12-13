package opentalk.service;

import opentalk.dao.ChatMessageRepository;
import opentalk.domainmodel.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by ivanchan on 29/11/2016.
 */
@Service("TalkService")
public class TalkServiceImp implements TalkService {
    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Override
    public ChatMessage addMessage(ChatMessage chatMessage) {
        UUID msgKey;

        if (chatMessage == null) {
            throw new IllegalArgumentException("chatMessage should not be null");
        }
        msgKey = chatMessage.getMessageKey();
        if (msgKey == null) {
            msgKey = UUID.randomUUID();
            chatMessage.setMessageKey(msgKey);
        }
        chatMessageRepository.save(chatMessage);
        ChatMessage savedMessage = chatMessageRepository.findOne(msgKey);
        return savedMessage;
    }
}
