package com.haji.MyFirstWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class todoService {
	private static List<todo> todos = new ArrayList();
	static {
		todos.add(new todo(1, "haji", "this is first todo ", LocalDate.now().plusYears(1), false));

		todos.add(new todo(2, "haji", "this is Second todo ", LocalDate.now().plusYears(2), false));

		todos.add(new todo(3, "haji", "this is third todo ", LocalDate.now().plusYears(3), false));

	}

	public List<todo> findByUserName(String name) {

		return todos;
	}

	public void AddTodo(todo t) {
		todos.add(t);
	}
}
