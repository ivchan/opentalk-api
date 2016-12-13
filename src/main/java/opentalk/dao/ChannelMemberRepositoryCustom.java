package opentalk.dao;

import opentalk.domainmodel.ChannelMember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * Created by Ivan Chan on 11/8/2016.
 */
public interface ChannelMemberRepositoryCustom {
    @Query("SELECT r FROM ChannelMember r where r.channelKey = :channelKey")
    Iterable<ChannelMember> listMembers(@Param("channelKey")UUID channelKey);
}
