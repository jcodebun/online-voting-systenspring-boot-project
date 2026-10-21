package com.online.voting.form;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.online.voting.dto.BaseDTO;
import com.online.voting.dto.VoteDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VoteForm extends BaseForm{
	
	@NotEmpty(message = "Voter Card Number is Required")
	private String votercardnumber;
	@NotEmpty(message = " Select Vote is Required")
	private String vote;
	
	private long partyid;
	
	@Override
	public BaseDTO getDTO() {
		VoteDTO dto = new VoteDTO();
		dto.setId(id);
		dto.setVotercardnumber(votercardnumber);
		dto.setVote(vote);
		dto.setPartyid(partyid);
		return dto;
	}
	@Override
	public void populate(BaseDTO bDto) {
		VoteDTO dto = (VoteDTO) bDto;
		id = dto.getId();
		votercardnumber = dto.getVotercardnumber();
		vote = dto.getVote();
		partyid = dto.getPartyid();
	}

}
