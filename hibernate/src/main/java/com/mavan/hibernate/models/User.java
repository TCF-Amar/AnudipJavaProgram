package com.mavan.hibernate.models;

import jakarta.persistence.*;

@Entity
@Table (name = "users1")
public class User {
	
	@Id
	private int id;
	
	@Column
	private String name;
	
	@Column (name = "email_address")
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		
		return email;
	}
	
	
	

}
