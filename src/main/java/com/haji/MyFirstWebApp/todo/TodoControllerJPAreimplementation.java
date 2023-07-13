package com.haji.MyFirstWebApp.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoControllerJPAreimplementation {
	@Autowired
	TodoRepository tr;

	@RequestMapping("listtodo")
	public String listtodos(ModelMap m) {

		List<todo> l = tr.findByusername(m.getAttribute("name").toString());
		m.addAttribute("todos", l);
		return "listtodo";
	}

	@RequestMapping("deletetodo")
	public String Deletetdos(@RequestParam int id) {
		tr.deleteById(id);
		return "redirect:listtodo";
	}

	@RequestMapping("statuschange")
	public String CHangeStatus(@RequestParam int id) {
		todo t = tr.getById(id);

		t.setDone(!(t.isDone()));
		tr.deleteById(id);
		tr.save(t);
		return "redirect:listtodo";
	}

	@RequestMapping("Add-todo")
	public String addingTodo(ModelMap m) {
		int i = tr.findAll().get((tr.findAll().size()) - 1).getId();
		todo t = new todo();
		String uname = (String) m.getAttribute("name");
		// System.out.println(uname);
		t.setUsername(uname);
		t.setId(i + 1);
		t.setDone(false);
		// System.out.println(t.toString()+"this is added get method");
		m.addAttribute("todo", t);

		return "Add-todo";
	}

	@RequestMapping(value = "Add-todo", method = RequestMethod.POST)
	public String AddedTodo(@ModelAttribute("todo") todo t, BindingResult R) {
		if (R.hasErrors()) {
			return "Add-todo";
		}
		tr.save(t);
		// System.out.println(tr.save(t).toString());
		return "redirect:listtodo";

	}

	@RequestMapping("UpdateTodo")
	public String UpdatingTodo(ModelMap m, @RequestParam int id) {
		m.addAttribute("todo", tr.getById(id));
		return "Add-todo";
	}
	
	@RequestMapping(value="UpdateTodo",method = RequestMethod.POST)
	public String UpdatedTodo(@ModelAttribute("todo") todo t,BindingResult R) {
		if(R.hasErrors()) {
			return "Add-todo";
		}
		tr.deleteById(t.getId());
		tr.save(t);
		return "redirect:listtodo";
		
	}

}
