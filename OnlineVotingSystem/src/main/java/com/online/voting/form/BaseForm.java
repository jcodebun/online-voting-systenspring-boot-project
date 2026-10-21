package com.online.voting.form;

import com.online.voting.dto.BaseDTO;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public abstract class BaseForm {

	protected long id;

	private String operation;

	public abstract BaseDTO getDTO();

	public abstract void populate(BaseDTO bDto);

}
