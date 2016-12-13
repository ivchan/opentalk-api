package opentalk.service;

import opentalk.domainmodel.Domain;
import opentalk.domainmodel.DomainMember;

import java.util.UUID;

/**
 * Created by Ivan Chan on 11/9/2016.
 */
public interface DomainService {
    Domain getDomain(UUID domainKey) throws Exception;
    Iterable<Domain> listDomains();
    Domain addDomain(Domain domain);
    Domain updateDomain(Domain domian);
    void deleteDomain(UUID domain);
    Iterable<DomainMember> listMembers();
    Iterable<DomainMember> listMembers(UUID domainKey);
}
