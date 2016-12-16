package opentalk.service;

import opentalk.dao.DomainMemberRepository;
import opentalk.dao.DomainRepository;
import opentalk.domainmodel.Domain;
import opentalk.domainmodel.DomainMember;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ivan Chan on 11/9/2016.
 */

@Service("DomainService")
public class DomainServiceImp implements DomainService {
    @Autowired
    private DomainRepository _domainRepository;
    @Autowired
    private DomainMemberRepository _domainMemberRepository;

    private ObjectId _domainKey;

    public DomainServiceImp() {
        this._domainKey = null;
    }

    public DomainServiceImp(ObjectId domainKey) {
        this._domainKey = domainKey;
    }

    @Override
    public Domain getDomain(ObjectId domainKey) {
        return _domainRepository.findOne(domainKey);
    }

    @Override
    public Iterable<Domain> listDomains() {
        return _domainRepository.findAll();
    }

    @Override
    public Domain addDomain(Domain domain) {
        if (domain.getDomainKey() == null) {
            domain.setDomainKey(new ObjectId());
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
    public void deleteDomain(ObjectId domainKey) {
        _domainRepository.delete(domainKey);
    }

    @Override
    public Iterable<DomainMember> listMembers() {
        return listMembers(_domainKey);
    }

    @Override
    public Iterable<DomainMember> listMembers(ObjectId domainKey) {
        //return _domainMemberRepository.listMember(domainKey);
        return null;
    }
}
