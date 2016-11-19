package com.sgm.implement;

import java.util.List;

import com.sgm.bean.User;
import com.sgm.dao.UserDao;
import com.sgm.service.UserService;

//每个实现类都要有对应的Dao get set。
public class UserServiceImp implements UserService {

	private UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public void deleteUserById(int id) {
        userDao.deleteUserById(id);		
	}

	@Override
	public void updateUser(User user) {
         userDao.updateUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User selectUser(String name,String password) {
		return userDao.selectUser(name,password);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}