package com.haji.MyFirstWebApp.login;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller

@SessionAttributes("name")
public class WelcomeController {
	private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("/")
	public String gotoWelcomePage(ModelMap m) {
		m.addAttribute("name", loggedInUserName());
		return "welcome";
	}

	String loggedInUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}

}
