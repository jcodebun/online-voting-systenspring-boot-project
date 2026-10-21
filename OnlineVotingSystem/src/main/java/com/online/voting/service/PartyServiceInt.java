package com.online.voting.service;

import java.util.List;

import com.online.voting.Exception.DuplicateRecordException;
import com.online.voting.dto.PartyDTO;

public interface PartyServiceInt {
	
	public long add(PartyDTO dto) throws DuplicateRecordException;
	
	public void Update(PartyDTO dto) throws DuplicateRecordException;
	
	public void Delete(long id);

	public List<PartyDTO> list();
	
	public PartyDTO FindByPk(long pk);
	
	public PartyDTO FindByParty(String party);
	
	public List<PartyDTO> search(PartyDTO dto);

}
