package com.online.voting.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "parties")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartyDTO extends BaseDTO{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String partyName;
	
	private String president;
	
	@OneToMany
	private List<VoteDTO> vote = new ArrayList<VoteDTO>();
	

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return null;
	}
	
	

}
