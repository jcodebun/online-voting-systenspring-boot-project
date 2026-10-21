package com.online.voting.dao;

import java.util.List;

import com.online.voting.dto.UserDTO;


public interface UserDAOInt {

	public long add(UserDTO dto);

	public void Update(UserDTO dto);

	public void Delete(long id);

	public List<UserDTO> list();

	public UserDTO FindByPk(long pk);

	public UserDTO FindByEmail(String email);

	public UserDTO Authentication(UserDTO dto);

	public List<UserDTO> search(UserDTO dto);
	
	public UserDTO VoterAuthentication(UserDTO dto);

}
