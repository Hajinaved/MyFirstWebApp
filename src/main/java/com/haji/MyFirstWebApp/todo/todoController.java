package com.haji.MyFirstWebApp.todo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class todoController {
	@Autowired
	todoService ts;

	@RequestMapping("listtodo")
	// @ResponseBody
	public String ll(Model m) {
		m.addAttribute("todos", ts.findByUserName((String) m.getAttribute("name")));

		return "listtodo";
		// return ts.findByUserName("HAJI").toString();

		// instead of returning the jsp i call a method that prints all the todos
		// directly to the page
		// return "listtodos";
	}

	@RequestMapping(value = "Add-todo", method = RequestMethod.POST)
	public String addnewTodo(ModelMap m, @Valid @ModelAttribute("todo") todo t, BindingResult R) {

		if (R.hasErrors()) {
			return "Add-todo";
		}

		String UserName = (String) m.getAttribute("name");

		ts.AddTodo(UserName, t.getDescription(), t.getTargetDate(), false);
		m.addAttribute("todos", ts.findByUserName("hai"));
		return "redirect:listtodo";
	}

	@RequestMapping("Add-todo")
	// listtodo.jsp to here to Add-todo.jsp >> then with details get to Add todo
	public String addtodo(ModelMap m) {
		String Uname = (String) m.getAttribute("name");
		todo todo = new todo(0, Uname, "", null, false);
		m.addAttribute(todo);
		return "Add-todo";
	}

	@RequestMapping("deletetodo")
	public String deleteTodo(@RequestParam int id) {

		ts.deleteTodo(id);
		return "redirect:listtodo";
	}

	@RequestMapping("UpdateTodo")
	public String UpdateTodo(@RequestParam int id, ModelMap m) {
		todo t = ts.getTodo(id);
		m.addAttribute("todo", t);

		return "Add-todo";
	}

	@RequestMapping(value = "UpdateTodo", method = RequestMethod.POST)
	public String UpdatedTodo(@ModelAttribute todo t, ModelMap m) {
		// ts.UpdateTodo(t.getId(), t.getDescription(),t.getTargetDate(), t.isDone());
		String name = (String) m.getAttribute("name");
		t.setUsername(name);
		ts.UpdateTodo(t);
		return "redirect:listtodo";
	}

	@RequestMapping("statuschange")
	public String statusChange(@RequestParam int id) {
		ts.changeStatus(id);
		return "redirect:listtodo";

	}
}
