package com.online.voting.form;

import javax.validation.constraints.NotEmpty;

import com.online.voting.dto.BaseDTO;
import com.online.voting.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VoterLoginForm extends BaseForm{
	
	@NotEmpty(message = "Voter Card Number is Required")
	private String votercardnumber;

	@Override
	public BaseDTO getDTO() {
		UserDTO bean = new UserDTO();
		bean.setVotercardnumber(votercardnumber);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		UserDTO bean = (UserDTO)getDTO();
		votercardnumber = bean.getVotercardnumber();
	}

}
