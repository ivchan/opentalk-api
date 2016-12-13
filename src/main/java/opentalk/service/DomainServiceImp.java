package opentalk.service;

import opentalk.dao.DomainMemberRepository;
import opentalk.dao.DomainRepository;
import opentalk.domainmodel.Domain;
import opentalk.domainmodel.DomainMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Ivan Chan on 11/9/2016.
 */

@Service("DomainService")
public class DomainServiceImp implements DomainService {
    @Autowired
    private DomainRepository _domainRepository;
    @Autowired
    private DomainMemberRepository _domainMemberRepository;

    private UUID _domainKey;

    public DomainServiceImp() {
        this._domainKey = null;
    }

    public DomainServiceImp(UUID domainKey) {
        this._domainKey = domainKey;
    }

    @Override
    public Domain getDomain(UUID domainKey) {
        return _domainRepository.findOne(domainKey);
    }

    @Override
    public Iterable<Domain> listDomains() {
        return _domainRepository.findAll();
    }

    @Override
    public Domain addDomain(Domain domain) {
        if (domain.getDomainKey().equals(new UUID(0, 0))) {
            domain.setDomainKey(UUID.randomUUID());
        }
        _domainRepository.save(domain);
        return domain;
    }

    @Override
    public Domain updateDomain(Domain domain) {
        _domainRepository.save(domain);
        return domain;
    }

    @Override
    public void deleteDomain(UUID domainKey) {
        _domainRepository.delete(domainKey);
    }

    @Override
    public Iterable<DomainMember> listMembers() {
        return listMembers(_domainKey);
    }

    @Override
    public Iterable<DomainMember> listMembers(UUID domainKey) {
        //return _domainMemberRepository.listMember(domainKey);
        return null;
    }
}
