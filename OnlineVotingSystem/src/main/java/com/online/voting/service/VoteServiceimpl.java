package com.online.voting.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.voting.Exception.DuplicateRecordException;
import com.online.voting.dao.VoteDAOInt;
import com.online.voting.dto.UserDTO;
import com.online.voting.dto.VoteDTO;

@Service
public class VoteServiceimpl implements VoteServiceInt{
	
	@Autowired
	public VoteDAOInt dao;

	@Override
	public long add(VoteDTO dto) throws DuplicateRecordException {
		VoteDTO exisBean = FindByVoterCardNumber(dto.getVotercardnumber(),dto.getUserid());
		if (exisBean != null){
			throw new DuplicateRecordException("Sorry Vote is allow only once and you already Used this Voter card Number");
		}
		long pk = dao.add(dto);
		return pk;
	}

	@Override
	public void Update(VoteDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void Delete(long id) {
		dao.Delete(id);
	}

	@Override
	public List<VoteDTO> list() {
		  List<VoteDTO> list =  dao.list();
			return list;
	}

	@Override
	public VoteDTO FindByPk(long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VoteDTO FindByVoterCardNumber(String votercardNumber,long userid) {
		VoteDTO dto = dao.FindByVoterCardNumber(votercardNumber,userid);
		return dto;
	}

}
