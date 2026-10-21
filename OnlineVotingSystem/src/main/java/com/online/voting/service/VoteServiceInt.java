package com.online.voting.service;

import java.util.List;

import com.online.voting.Exception.DuplicateRecordException;
import com.online.voting.dto.UserDTO;
import com.online.voting.dto.VoteDTO;

public interface VoteServiceInt {
	
    public long add(VoteDTO dto) throws DuplicateRecordException;
	
	public void Update(VoteDTO dto) throws DuplicateRecordException;
	
	public void Delete(long id);

	public List<VoteDTO> list();
	
	public VoteDTO FindByPk(long pk);
	
	public VoteDTO FindByVoterCardNumber(String votercardnumber,long userid);
	
	
}
