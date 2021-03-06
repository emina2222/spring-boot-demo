package com.eminam.todo.model;

import java.util.Date;

public class Todo {
	
	private int id;
	private String username;
	private String description;
	private Date date;
	private boolean isDone;
	
	
	public Todo(int id, String username, String description, Date date, boolean isDone) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.date = date;
		this.setDone(isDone);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	

}
