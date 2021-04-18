package com.eminam.todo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHarcodedService {
	
	private static List<Todo> todos=new ArrayList<>();
	private static int idCounter=0;
	
	static {
		todos.add(new Todo(++idCounter,"emina","Learning everything",new Date(),true));
		todos.add(new Todo(++idCounter,"misha","Babyyy",new Date(),false));
		todos.add(new Todo(++idCounter,"arija","Learning to talk",new Date(),false));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo deleteById(int id) {
		Todo todo=findById(id);
		todos.remove(todo);
		return todo;
	}

	private Todo findById(int id) {
		for(Todo t:todos) {
			if(t.getId()==id) {
				return t;
			}
		}
		return null;
	}

}
