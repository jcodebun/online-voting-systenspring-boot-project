package com.online.voting.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeCtl {
	
	@GetMapping({"/home","/welcome"})
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping({"/home","/"})
	public String about() {
		return "aboutus";
	}

}
