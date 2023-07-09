package com.haji.MyFirstWebApp.login;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller

@SessionAttributes("name")
public class WelcomeController {
	private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
	
	

	@RequestMapping("/")
	public String gotoWelcomePage(ModelMap m) {
		m.addAttribute("name","HAJI");
		return "welcome";
	}

	

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("name");
		return "logging_out";
	}
}
