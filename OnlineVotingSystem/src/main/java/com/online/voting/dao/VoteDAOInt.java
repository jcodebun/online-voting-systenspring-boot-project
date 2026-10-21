package com.online.voting.dao;

import java.util.List;

import com.online.voting.dto.UserDTO;
import com.online.voting.dto.VoteDTO;

public interface VoteDAOInt {
	
	public long add(VoteDTO dto);

	public void Update(VoteDTO dto);

	public void Delete(long id);

	public List<VoteDTO> list();

	public VoteDTO FindByPk(long pk);

	public VoteDTO FindByVoterCardNumber(String votercardnumber,long userid);


	

}
