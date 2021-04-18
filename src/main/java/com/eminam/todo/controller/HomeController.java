package com.eminam.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eminam.todo.model.HelloWorldBean;
import com.eminam.todo.model.Todo;
import com.eminam.todo.model.TodoHarcodedService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class HomeController {
	
	@Autowired
	private TodoHarcodedService service;
	
	@RequestMapping(value="/hello-world",method=RequestMethod.GET)
	public String showHello() {
		return "Hello World";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean showBean() {
		return new HelloWorldBean("Hello user!");
	}
	
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWithVar(@PathVariable String name) {
		throw new RuntimeException("Something went wrong.");
		//return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return service.findAll();
	}

	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id){
		Todo todo=service.deleteById(id);
		if(todo!=null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
