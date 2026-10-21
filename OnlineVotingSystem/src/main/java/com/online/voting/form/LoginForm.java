package com.online.voting.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.online.voting.dto.BaseDTO;
import com.online.voting.dto.UserDTO;
import com.online.voting.form.BaseForm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginForm extends BaseForm{

	@NotNull(message = "Email Is Required")
	private String email;
	
	@NotNull(message = "Password is Required")
	private String password;
	
	@Override
	public BaseDTO getDTO() {
		UserDTO bean = new UserDTO();
		bean.setEmail(email);
		bean.setPassword(password);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		UserDTO bean = (UserDTO)getDTO();
		email = bean.getEmail();
		password = bean.getPassword();
	}

}
