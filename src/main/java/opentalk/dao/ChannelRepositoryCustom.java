package opentalk.dao;

import opentalk.domainmodel.Channel;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by Ivan Chan on 11/8/2016.
 */
public interface ChannelRepositoryCustom {
    @Query("{'isPublicChannel' : true}")
    List<Channel> findPublicChannels();

    @Query("{'isPublicChannel' : false}")
    List<Channel> findPrivateChannels();
}
