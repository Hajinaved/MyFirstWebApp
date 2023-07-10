package com.haji.MyFirstWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class todoService {

	private Logger ogger = LoggerFactory.getLogger(this.getClass());

	private static int todoCount = 0;
	private static List<todo> todos = new ArrayList();
	/*//static function that will be executed in the beginning
	 * static { todos.add(new todo(++todoCount, "haji", "this is first todo ",
	 * LocalDate.now().plusYears(1), false));
	 * 
	 * todos.add(new todo(++todoCount, "haji", "this is Second todo ",
	 * LocalDate.now().plusYears(2), false));
	 * 
	 * todos.add(new todo(++todoCount, "haji", "this is third todo ",
	 * LocalDate.now().plusYears(3), false));
	 * 
	 * }
	 */

	public void UpdateTodo(String Uname, int id, String desc, LocalDate ld, boolean isdone) {
		todo td = todos.stream().filter(t -> (t.getId() == id)).findFirst().orElse(null);
		td.setDescription(desc);
		td.setDone(isdone);
		td.setTargetDate(ld);

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
		return todos.stream().filter(t -> (t.getUsername().equalsIgnoreCase(name))).toList();
	}

	public void AddTodo(String Uname, String description, LocalDate ld, boolean isdone) {
		todos.add(new todo(++todoCount, Uname, description, ld, isdone));
		// todos.add(new todo(++todoCount, "haji", description,
		// LocalDate.now().plusMonths(1).plusDays(2), false));
	}

	public void AddTodo(todo t) {
		todos.add(t);
	}

	public void UpdateTodo(@Valid todo t) {
		// TODO Auto-generated method stub
		int i = t.getId();
		todos.removeIf(td -> (td.getId() == i));
		todos.add(new todo(i, t.getUsername(), t.getDescription(), t.getTargetDate(), t.isDone()));
		ogger.info("UPDATEED" + t.toString());

	}

	public void changeStatus(int id) {
		todo td = todos.stream().filter(t -> (t.getId() == id)).findAny().orElse(null);
		td.setDone(!(td.isDone()));
	}
}
