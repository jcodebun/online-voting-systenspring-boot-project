package com.online.voting.Controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.online.voting.dto.UserDTO;
import com.online.voting.form.LoginForm;
import com.online.voting.form.VoterLoginForm;
import com.online.voting.service.UserServiceImpl;



@Controller
public class LoginCtl extends BaseCtl{
	
	protected static final String OP_SIGNIN = "SignIn";
	protected static final String OP_SIGNUP = "SignUp";
	protected static final String OP_LOGOUT = "Logout";
	
	
	@Autowired
	public UserServiceImpl userserice;

	
	@GetMapping("/voterlogin") 
	public String VoterLogindisplay(@ModelAttribute("form")VoterLoginForm form,HttpSession session,Model model) {
		if (session.getAttribute("user") != null) {
			session.invalidate();
			model.addAttribute("success", "You have Logout Successfully !!");
		}
		return "voter";
	}
	
	@PostMapping("/votersubmit")
	public String Voterlogin(@RequestParam String operation,HttpSession session,@Valid @ModelAttribute("form") VoterLoginForm form,BindingResult 
			bindingResult,Model model,HttpServletRequest request){
	
	if (bindingResult.hasErrors()) {
		return "voter";
	}
	
	
	UserDTO bean = userserice.VoterAuthentication((UserDTO)form.getDTO());
	if (bean != null) {
		if (bean.getRoleid() == 0) {
			model.addAttribute("msg", "Voter Card Number is Reqired");
			return "voter";
		}
		session.setAttribute("user", bean);
		return "redirect:/";
	}
	if (bean == null) {
		model.addAttribute("error", "Voter Card Number Invalid");
	}
	return "voter";
	}
	
	@GetMapping("/loginView") 
	public String display(@ModelAttribute("form")LoginForm form,HttpSession session,Model model) {
		if (session.getAttribute("user") != null) {
			session.invalidate();
			model.addAttribute("success", "You have Logout Successfully !!");
		}
		return "login";
	}
	
	@PostMapping("/loginView")
	public String login(@RequestParam String operation,HttpSession session,@Valid @ModelAttribute("form") LoginForm form,BindingResult 
			bindingResult,Model model,HttpServletRequest request){
	
	if (bindingResult.hasErrors()) {
		return "login";
	}
	
	
	UserDTO bean = userserice.Authentication((UserDTO)form.getDTO());
	if (bean != null) {
		if (bean.getRoleid() == 0) {
			model.addAttribute("msg", "Email Id & Password Reqired");
			return "login";
		}
		session.setAttribute("user", bean);
		return "redirect:/";
	}
	if (bean == null) {
		model.addAttribute("error", "Email Id & Password Invalid");
	}
	return "login";
	}
	
}
