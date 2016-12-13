package opentalk.dao;

import opentalk.domainmodel.Channel;
import opentalk.domainmodel.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Ivan Chan on 11/8/2016.
 */
public interface ChannelRepositoryCustom {
    @Query("SELECT c FROM Channel c where c.isPublicChannel = true")
    List<Channel> findPublicChannels();

    @Query("SELECT c FROM Channel c where c.isPublicChannel = false")
    List<Channel> findPrivateChannels();
}
