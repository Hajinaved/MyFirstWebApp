package com.haji.MyFirstWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class todoService {
	private static int todoCount = 0;
	private static List<todo> todos = new ArrayList();
	static {
		todos.add(new todo(++todoCount, "haji", "this is first todo ", LocalDate.now().plusYears(1), false));

		todos.add(new todo(++todoCount, "haji", "this is Second todo ", LocalDate.now().plusYears(2), false));

		todos.add(new todo(++todoCount, "haji", "this is third todo ", LocalDate.now().plusYears(3), false));

	}

	public todo getTodo(int id) {
		return todos.stream().filter(t -> (t.getId() == id)).findAny().orElse(null);
	}

	public void deleteTodo(int id) {
		if (todos.removeIf(t -> (t.getId() == id))) {
			for (todo t : todos) {
				if (t.getId() > id) {
					int i = t.getId();
					t.setId(i - 1);
				}
			}
			todoCount--;
		}

	}

	public List<todo> findByUserName(String name) {

		return todos;
	}

	public void AddTodo(String Uname, String description, LocalDate ld, boolean isdone) {
		todos.add(new todo(++todoCount, Uname, description, ld, isdone));
		// todos.add(new todo(++todoCount, "haji", description,
		// LocalDate.now().plusMonths(1).plusDays(2), false));
	}

	public void AddTodo(todo t) {
		todos.add(t);
	}
}
