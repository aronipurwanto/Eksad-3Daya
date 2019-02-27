package com.eksad.pos.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	private Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginForm(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			Model model) {
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		return "login";
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/403")
	public String accessDenied() {
		return "403";
	}
}
