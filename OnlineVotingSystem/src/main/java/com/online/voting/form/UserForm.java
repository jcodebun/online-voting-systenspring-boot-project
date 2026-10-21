package com.online.voting.form;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.online.voting.dto.BaseDTO;
import com.online.voting.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserForm extends BaseForm{
	
	@NotEmpty(message = "UserName is Required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "UserName is Invalid")
	private String userName;
	
	@NotEmpty(message = "Email is Required")
	@Pattern(regexp="(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$",message = "Email id is invalid")
	private String email;
	
	@NotEmpty(message = "Password is Require")
	//@Pattern(regexp="(^?=.*[A-Z](?=.*[a-z])(?=.*[0-9])(?=.*[\\\\S])[A-Za-z0-9\\\\S]{6,12})*$",message = "Password is invalid")
	private String password;
	
	@NotEmpty(message = "Phone No is Required")
	//@Pattern(regexp="(^[7-9][0-9]{9})*$",message = "Phone No is invalid")
	private String phoneNo;
	
	@NotEmpty(message = "Gender is Required")	
	private String gender;
	
	private long roleid;
	
	private String rolename;
	@NotEmpty(message = "Voter Card Number is Required")
	private String votercardnumber;
	@NotEmpty(message = "Address is Required")
	private String address;
	private Date dob;
	

	@Override
	public BaseDTO getDTO() {
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setUserName(userName);
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setPhoneNo(phoneNo);
		dto.setGender(gender);
		dto.setRoleid(2);
		dto.setRolename("User");
		dto.setVotercardnumber(votercardnumber);
		dto.setAddress(address);
		dto.setDob(dob);
		return dto;
	}


	@Override
	public void populate(BaseDTO bDto) {
		UserDTO dto=(UserDTO) bDto;
		id = dto.getId();
		userName = dto.getUserName();
		email = dto.getEmail();
		password = dto.getPassword();
		phoneNo = dto.getPhoneNo();
		gender = dto.getGender();
		votercardnumber = dto.getVotercardnumber();
		address = dto.getAddress();
		dob = dto.getDob();
	}
		


}
