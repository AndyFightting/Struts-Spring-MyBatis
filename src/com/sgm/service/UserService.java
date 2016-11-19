package com.sgm.service;

import java.util.List;

import com.sgm.bean.User;

public interface UserService {
	
	public void addUser(User user);
	
	public void deleteUserById(int id);
	
	public void updateUser(User user);
	
	public List<User> getAllUsers();
	
	public User selectUser(String name, String password);
}
