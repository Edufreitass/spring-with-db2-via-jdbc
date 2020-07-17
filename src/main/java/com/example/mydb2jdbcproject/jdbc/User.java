package com.example.mydb2jdbcproject.jdbc;

public class User {

	private Long id;
	private String name;

	public User() {

	}

	public User(long id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("User[id=%d, name='%s']", id, name);
	}
}
