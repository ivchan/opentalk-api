package opentalk.service;

import opentalk.dao.ChatMessageRepository;
import opentalk.domainmodel.ChatMessage;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ivanchan on 29/11/2016.
 */
@Service("TalkService")
public class TalkServiceImp implements TalkService {
    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Override
    public ChatMessage addMessage(ChatMessage chatMessage) {
        ObjectId msgKey;

        if (chatMessage == null) {
            throw new IllegalArgumentException("chatMessage should not be null");
        }
        msgKey = chatMessage.getMessageKey();
        if (msgKey == null) {
            msgKey = new ObjectId();
            chatMessage.setMessageKey(msgKey);
        }
        chatMessageRepository.save(chatMessage);
        ChatMessage savedMessage = chatMessageRepository.findOne(msgKey);
        return savedMessage;
    }
}
