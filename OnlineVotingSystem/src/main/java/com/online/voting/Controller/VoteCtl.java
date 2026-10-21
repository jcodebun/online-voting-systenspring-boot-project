package com.online.voting.Controller;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.online.voting.Exception.DuplicateRecordException;
import com.online.voting.dto.PartyDTO;
import com.online.voting.dto.UserDTO;
import com.online.voting.dto.VoteDTO;
import com.online.voting.form.PartyForm;
import com.online.voting.form.VoteForm;
import com.online.voting.service.PartyServiceImpl;
import com.online.voting.service.UserServiceImpl;
import com.online.voting.service.VoteServiceInt;

@Controller
public class VoteCtl extends BaseCtl{
	
	
	@Autowired
	public VoteServiceInt service;
	
	@Autowired
	public UserServiceImpl userserice;
	
	@Autowired
	private PartyServiceImpl partyService;
	
	@ModelAttribute
	public void preload(Model model)
	{
		List<PartyDTO> list = partyService.list();
		model.addAttribute("partylist", list);
	}
	
	@GetMapping("/doVote")
	public String voteView(@ModelAttribute("form")VoteForm form,HttpSession session,Model model, HttpServletRequest request){
		return "vote";
	}
	
	@PostMapping("/dovote")
	public String submit(@RequestParam String operation,HttpSession session,@Valid @ModelAttribute("form") VoteForm form,BindingResult 
			bindingResult,Model model,HttpServletRequest request) {
		
		
//		if (bindingResult.hasErrors()) {
//			return "vote";
//		}
		
		try {
				VoteDTO vbean = (VoteDTO) populateDTO(form.getDTO(), request);
				UserDTO uDto=(UserDTO)session.getAttribute("user");
				vbean.setUserid(uDto.getId());
				vbean.setVotercardnumber(uDto.getVotercardnumber());
				long partyid = vbean.getPartyid();
				PartyDTO partyDto = partyService.FindByPk(partyid);
				String partyName = partyDto.getPartyName();
				vbean.setVote(partyName);
				service.add(vbean);
				model.addAttribute("success", "Your Vote Done");
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
		}
		return "vote";

	}
	
	@RequestMapping(value = "/VoteList", method = { RequestMethod.GET, RequestMethod.POST })
	public String VoteList(@ModelAttribute("form") VoteForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/VoteList";
		}
		
		
		List<VoteDTO> list = service.list();
		Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(VoteDTO :: getVote,Collectors.counting()));
		
		//System.out.println(collect.toString());
		model.addAttribute("collectMap", collect);
		return "votelist";
	}
	
	@RequestMapping(value = "/VotersVoteList", method = { RequestMethod.GET, RequestMethod.POST })
	public String VotersVoteList(@ModelAttribute("form") VoteForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/VotersVoteList";
		}
		
		List<VoteDTO> list = service.list();
		model.addAttribute("list", list);
		return "votersvotelist";
	}
	
	@GetMapping("/Delete")
	public String Delete(@ModelAttribute("form") VoteForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {
		service.Delete(id);
		model.addAttribute("success", "Deleted Successfully!!!");
		List<VoteDTO> list = service.list();
		model.addAttribute("list", list);
		return "votersvotelist";
	}


}
