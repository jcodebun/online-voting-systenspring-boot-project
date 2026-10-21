package com.online.voting.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.voting.dto.VoteDTO;

@Repository
public class VoteDAOImpl implements VoteDAOInt {

	@Autowired
	public EntityManager entitymanger;

	@Override
	public long add(VoteDTO dto) {
		Session session = entitymanger.unwrap(Session.class);
		long pk = (long) session.save(dto);
		return pk;
	}

	@Override
	public void Update(VoteDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete(long id) {
		Session session = entitymanger.unwrap(Session.class);
		Query query = session.createQuery("delete from VoteDTO where id= "+id+"");
		query.executeUpdate();

	}

	@Override
	public List<VoteDTO> list() {
		Session session = entitymanger.unwrap(Session.class);
		Query<VoteDTO> query = session.createQuery("from VoteDTO", VoteDTO.class);
		List<VoteDTO> list = query.getResultList();
		return list;
	}

	@Override
	public VoteDTO FindByPk(long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VoteDTO FindByVoterCardNumber(String votercardnumber, long userid) {
		Session session = entitymanger.unwrap(Session.class);
		Query<VoteDTO> query = session.createQuery("from VoteDTO as u where u.votercardnumber=?1 or u.userid=?2",VoteDTO.class);
		query.setParameter(1, votercardnumber);
		query.setParameter(2, userid);
		System.out.println("votercardnumber:" + votercardnumber);
		System.out.println(" userid:" + userid);
		Optional<VoteDTO> opVote = query.getResultStream().findFirst();
		if (opVote.isPresent()) {
			return opVote.get();
		} else {
			return null;
		}
	}

}
