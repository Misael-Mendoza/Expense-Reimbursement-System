package com.example.service;

import java.util.List;

import com.example.dao.UserDao;
import com.example.model.Reimbursement;
import com.example.model.User;

public class UserService {
	private UserDao uDao;
	
	public UserService() {
		// TODO Auto-generated constructor stub
	}
	
	public UserService(UserDao uDao) {
		super();
		this.uDao = uDao;
	}
	
	public User getUser(String username) {
		User user = uDao.findByName(username);
		if(user == null) {
			throw new NullPointerException();
		}
		return user;
	}
	
	public boolean verifyUser(String username, String password) {
		boolean isUserVerified = false;
		User user = getUser(username);
		if(user.getPassword().equals(password)) {
			isUserVerified = true;
		}
		return isUserVerified;
	}
	
	public void signUpUser(String username, String password, String firstName, String lastName, String email, String roleId) {
		
		User user = new User(username,password,firstName,lastName,email,Integer.parseInt(roleId));
		uDao.Insert(user);
	}
	
	
}
