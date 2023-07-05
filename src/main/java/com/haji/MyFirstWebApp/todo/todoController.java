package com.haji.MyFirstWebApp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class todoController {
	@Autowired
	todoService ts;

	@RequestMapping("listtodo")
	//@ResponseBody
	public String ll(Model m) {
		m.addAttribute("todos", ts.findByUserName("hahi"));
		return "listtodo";
		//return ts.findByUserName("HAJI").toString();

		// instead of returning the jsp i call a method that prints all the todos
		// directly to the page
		// return "listtodos";
	}
	
	
}
