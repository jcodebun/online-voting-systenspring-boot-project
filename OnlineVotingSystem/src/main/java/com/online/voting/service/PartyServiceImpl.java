package com.online.voting.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.voting.Exception.DuplicateRecordException;
import com.online.voting.dao.PartyDAOInt;
import com.online.voting.dto.PartyDTO;

@Service
public class PartyServiceImpl implements PartyDAOInt{
	
	@Autowired
	private PartyDAOInt dao;

	@Override
	public long add(PartyDTO dto) throws DuplicateRecordException {
		PartyDTO bean = dao.FindByParty(dto.getPartyName());
		if (bean != null) {
			throw new DuplicateRecordException("Party Name Already Exist");
		}
		long pk = dao.add(dto);
		return pk;
	}

	@Override
	@Transactional
	public void Update(PartyDTO dto) throws DuplicateRecordException {
		dao.Update(dto);
	}

	@Override
	@Transactional
	public void Delete(long id) {
		dao.Delete(id);
	}

	@Override
	public List<PartyDTO> list() {
		List<PartyDTO> list = dao.list();
		return list;
	}

	@Override
	public PartyDTO FindByPk(long pk) {
		PartyDTO dto = dao.FindByPk(pk);
		return dto;
	}

	@Override
	public PartyDTO FindByParty(String party) {
		PartyDTO dto = dao.FindByParty(party);
		return dto;
	}

	@Override
	public List<PartyDTO> search(PartyDTO dto) {
		List<PartyDTO> list = dao.search(dto);
		return list;
	}

	
}
