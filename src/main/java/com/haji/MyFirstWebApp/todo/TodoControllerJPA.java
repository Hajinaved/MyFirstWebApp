package com.haji.MyFirstWebApp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {
	@Autowired
	todoService ts;
	@Autowired
	TodoRepository tr;

	@RequestMapping("listtodo")
	// @ResponseBody
	public String ll(Model m) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		String naam = auth.getName();
		m.addAttribute("todos", tr.findByusername(naam));

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
		if(tr.getById(t.getId()) != null) {
			tr.deleteById(t.getId());
		}
		t.setUsername(UserName);
		tr.save(t);
		//System.out.println(t.toString());
		//ts.AddTodo(UserName, t.getDescription(), t.getTargetDate(), false);
		//m.addAttribute("todos", tr.findByusername("hai"));
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
		tr.deleteById(id);
	//	ts.deleteTodo(id);
		return "redirect:listtodo";
	}

	@RequestMapping("UpdateTodo")
	public String UpdateTodo(@RequestParam int id, ModelMap m) {
		//todo t = ts.getTodo(id);
		todo t=tr.getById(id);
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
