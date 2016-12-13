package opentalk.dao;

import opentalk.domainmodel.DomainMember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * Created by Ivan Chan on 11/8/2016.
 */
public interface DomainMemberRepositoryCustom {
    @Query("SELECT r FROM DomainMember r where r.domainKey = :domainKey")
    Iterable<DomainMember> listMember(@Param("domainKey")UUID domainKey);
}
