package com.online.voting.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
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
import com.online.voting.form.UserForm;
import com.online.voting.form.VoteForm;
import com.online.voting.service.PartyServiceImpl;

@Controller
public class PartyCtl extends BaseCtl{
	
	
	@Autowired
	private PartyServiceImpl service;
	
	
	@GetMapping("/addparties")
	public String party(@ModelAttribute("form") PartyForm form,Session session,Model model,HttpServletRequest request)
	{
		return "party";
	}
	
	@PostMapping("/partysubmit")
	public String submit(@RequestParam String operation,HttpSession session,@Valid @ModelAttribute("form") PartyForm form,BindingResult 
			bindingResult,Model model,HttpServletRequest request) {
		
		if (bindingResult.hasErrors()) {
			return "party";
		}
		
		try {
				PartyDTO bean = (PartyDTO) populateDTO(form.getDTO(), request);
				service.add(bean);
				model.addAttribute("success", "Party Added Successfully !!");
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
		}
		return "party";
	}
	

	@RequestMapping(value = "/PartyList", method = { RequestMethod.GET, RequestMethod.POST })
	public String UserList(@ModelAttribute("form") PartyForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/PartyList";
		}
		
		if (OP_SEARCH.equalsIgnoreCase(form.getOperation())) {
			PartyDTO dto = (PartyDTO) form.getDTO();
			List<PartyDTO> list = service.search(dto);
			model.addAttribute("list", list);
			return "Partylist";
		}
		List<PartyDTO> list = service.list();
		model.addAttribute("list", list);
		return "Partylist";
	}
	
	@GetMapping("/party/Delete")
	public String Delete(@ModelAttribute("form") PartyForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {
		service.Delete(id);
		model.addAttribute("success", "Deleted Successfully!!!");
		List<PartyDTO> list = service.list();
		model.addAttribute("list", list);
		return "Partylist";
	}
	
	@GetMapping("/party/update")
	public String findByPk(@ModelAttribute("form") PartyForm form,
			@RequestParam(required = false) String operation, Long id, HttpSession session, Model model) {
		PartyDTO bean = service.FindByPk(id);
		form.populate(bean);
		return "partyupdate";
	}
	
	@PostMapping("/party/update")
	public String update(@ModelAttribute("form") PartyForm form,
			@RequestParam(required = false) String operation,HttpSession session, BindingResult bindingResult,Model model,HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "partyupdate";
		}
		try {
			if (OP_UPDATE.equalsIgnoreCase(form.getOperation())) {
				PartyDTO entity = (PartyDTO) populateDTO(form.getDTO(), request);
				service.Update(entity);
				model.addAttribute("success", "Party Data Updated");
				return "partyupdate";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "partyupdate";
		}
		return "partyupdate";
	}
	

}
