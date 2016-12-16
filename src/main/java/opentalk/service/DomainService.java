package opentalk.service;

import opentalk.domainmodel.Domain;
import opentalk.domainmodel.DomainMember;
import org.bson.types.ObjectId;

/**
 * Created by Ivan Chan on 11/9/2016.
 */
public interface DomainService {
    Domain getDomain(ObjectId domainKey) throws Exception;
    Iterable<Domain> listDomains();
    Domain addDomain(Domain domain);
    Domain updateDomain(Domain domian);
    void deleteDomain(ObjectId domain);
    Iterable<DomainMember> listMembers();
    Iterable<DomainMember> listMembers(ObjectId domainKey);
}
