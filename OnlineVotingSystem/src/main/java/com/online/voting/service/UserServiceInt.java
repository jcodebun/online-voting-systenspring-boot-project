package com.online.voting.service;

import java.util.List;

import com.online.voting.Exception.DuplicateRecordException;
import com.online.voting.dto.UserDTO;


public interface UserServiceInt {
	
	public long add(UserDTO dto) throws DuplicateRecordException;
	
	public void Update(UserDTO dto) throws DuplicateRecordException;
	
	public void Delete(long id);

	public List<UserDTO> list();
	
	public UserDTO FindByPk(long pk);
	
	public UserDTO FindByEmail(String email);
	
	public UserDTO Authentication(UserDTO dto);
	
	public List<UserDTO> search(UserDTO dto);
	
	public UserDTO VoterAuthentication(UserDTO dto);
	
}
