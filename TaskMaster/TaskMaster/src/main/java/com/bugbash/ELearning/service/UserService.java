package com.bugbash.ELearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugbash.ELearning.model.Users;
import com.bugbash.ELearning.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
public List<Users> findUser(){
	
	return repo.findAll();
}
public void addUser(Users user) {
	repo.save(user);
}
public void forget(Users user, String newpass) {
user.setPassword(newpass);
repo.save(user);
}



}