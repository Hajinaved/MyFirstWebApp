package com.haji.MyFirstWebApp.login;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.classic.Logger;

@Controller
public class loginController {
	private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("log")
	public String asds(@RequestParam String name, ModelMap m) {
		m.put("name", name);
		logger.debug("the values of the requested param is " + name);
		return "Login2";
	}

	@RequestMapping("login")
	public String asd() {
		return "login";
	}
	//for Get one -> this will return a response body directly
	@RequestMapping(value="loggedValues",method=RequestMethod.GET)
	@ResponseBody
	public String retVaa(@RequestParam("name")String name,@RequestParam("password")String pass) {
		return "UserName is "+name+"<br> Password is "+pass;
	}

	@RequestMapping(value="loggedValues",method=RequestMethod.POST)
	//@ResponseBody
	public String retVal(@RequestParam("name") String name, @RequestParam("password") String pass,
			Model m) {
		m.addAttribute("name", name);
		m.addAttribute("pass", pass);
		return "logCred";
	}
}
