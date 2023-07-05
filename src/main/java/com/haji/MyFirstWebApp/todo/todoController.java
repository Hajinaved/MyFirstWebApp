package com.haji.MyFirstWebApp.todo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class todoController {
	@Autowired
	todoService ts;

	@RequestMapping("listtodo")
	// @ResponseBody
	public String ll(Model m) {
		m.addAttribute("todos", ts.findByUserName("hahi"));
		return "listtodo";
		// return ts.findByUserName("HAJI").toString();

		// instead of returning the jsp i call a method that prints all the todos
		// directly to the page
		// return "listtodos";
	}
	@RequestMapping(value="Add-todo",method=RequestMethod.POST)
	public String addnewTodo() {
		return "redirect:listtodo";
	}
	
	@RequestMapping("Add-todo")
	// listtodo.jsp to here to Add-todo.jsp >> then with details get to Add todo
	public String addtodo() {

		return "Add-todo";
	}

}
