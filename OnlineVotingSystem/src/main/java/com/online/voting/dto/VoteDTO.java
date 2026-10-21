package com.online.voting.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vote")
@Setter
@Getter
public class VoteDTO extends BaseDTO{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "votercardnumber",length = 200)
	private String votercardnumber;
	
	private long userid;
	
	@Column(name = "Vote",length = 200)
	private String vote;
	
	@ManyToOne
	private PartyDTO parties;
	
	private long partyid;
	

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return null;
	}
	
	

}
