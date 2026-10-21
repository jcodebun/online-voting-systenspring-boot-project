package com.online.voting.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.voting.Exception.DuplicateRecordException;
import com.online.voting.dto.PartyDTO;
import com.online.voting.dto.UserDTO;


@Repository
public class PartyDAOImpl implements PartyDAOInt{
	
	@Autowired
	private EntityManager entitymanager;

	@Override
	public long add(PartyDTO dto) throws DuplicateRecordException {
		Session session = entitymanager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		return pk;
	}

	@Override
	public void Update(PartyDTO dto) throws DuplicateRecordException {
		Session session = entitymanager.unwrap(Session.class);
		session.merge(dto);
		
	}

	@Override
	public void Delete(long id) {
		Session session = entitymanager.unwrap(Session.class);
		Query query = session.createQuery("delete from PartyDTO where id= "+id+"");
		query.executeUpdate();
		
	}

	@Override
	public List<PartyDTO> list() {
		Session session = entitymanager.unwrap(Session.class);
		Query query = session.createQuery("from PartyDTO");
		List list = query.getResultList();
		return list;
	}

	@Override
	public PartyDTO FindByPk(long pk) {
		Session session = entitymanager.unwrap(Session.class);
		PartyDTO dto = session.get(PartyDTO.class, pk);
		return dto;
	}

	@Override
	public PartyDTO FindByParty(String party) {
		Session session = entitymanager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(PartyDTO.class);
		criteria.add(Restrictions.eq("partyName", party));
		PartyDTO dto =  (PartyDTO) criteria.uniqueResult();
		return dto;
	}

	@Override
	public List<PartyDTO> search(PartyDTO dto) {
		Session session = entitymanager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(PartyDTO.class);
		if (dto != null) {
			if (dto.getId()>0) {
              criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getPartyName() != null && dto.getPartyName().length()>0) {
				criteria.add(Restrictions.like("partyName", dto.getPartyName() + "%"));
			}
		}
		return criteria.list();
	}

}
