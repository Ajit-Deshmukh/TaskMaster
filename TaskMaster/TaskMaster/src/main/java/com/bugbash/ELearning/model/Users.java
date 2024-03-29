package com.bugbash.ELearning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Table
@Entity
public class Users {
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
private String name;
private String email;
private String contact;
private String password;

public String getName() {
	return name;
}
public void setUsername(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContact() {
	return contact;
}
public void setPhone(String contact) {
	this.contact = contact;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Users(String name, String email, String contact, String password) {
	super();
	this.name = name;
	this.email = email;
	this.contact = contact;
	this.password = password;
}
public Users() {
	super();
}
@Override
public String toString() {
	return "Users [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact + ", password=" + password
			+ "]";
}


}