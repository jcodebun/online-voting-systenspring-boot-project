package com.online.voting.form;

import javax.validation.constraints.NotEmpty;

import com.online.voting.dto.BaseDTO;
import com.online.voting.dto.PartyDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PartyForm extends BaseForm{

   @NotEmpty(message = "Party Name is Required")
	private String partyName;
    @NotEmpty(message = "President Name is Required")
	private String president;
    
	@Override
	public BaseDTO getDTO() {
		PartyDTO dto = new PartyDTO();
		dto.setId(id);
		dto.setPartyName(partyName);
		dto.setPresident(president);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		PartyDTO bean = (PartyDTO)bDto;
		id = bean.getId();
		partyName = bean.getPartyName();
		president = bean.getPresident();
	}

}
