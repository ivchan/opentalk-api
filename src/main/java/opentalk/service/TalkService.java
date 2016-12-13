package opentalk.service;

import opentalk.domainmodel.ChatMessage;

/**
 * Created by ivanchan on 29/11/2016.
 */
public interface TalkService {
    ChatMessage addMessage(ChatMessage chatMessage);
}
