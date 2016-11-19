package com.sgm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sgm.bean.User;

public interface UserDao {
//	方法名要和user.xml配置文件里的id名称一样
	public void addUser(User user);
	
	public void deleteUserById(int id);
	
	public void updateUser(User user);
	
	public List<User> getAllUsers();
	
	public User selectUser(@Param("name")String name,@Param("password")String password);
}
