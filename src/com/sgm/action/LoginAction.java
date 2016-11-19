package com.sgm.action;

import java.util.ArrayList;
import java.util.List;
import com.sgm.bean.User;

/*
 * 项目结构：
 * Action里调用Service接口，Service接口注入某个Service的实现，
 * 在Service的实现里调用Dao来处理数据库。而Dao是用Mybatis通过对应的xml文件来映射的。
 * 且Action里的Service对象和Service实现类里的Dao对象是通过Spring配置文件注入的。
 */
public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 3394930191358237768L;

	// 名称与jsp页面属性名对应，需要get set方法.
	// struts标签 http://jimingsong.iteye.com/blog/1582939

	private String loginName;
	private String password;
	private User user;
	private List<User> userList = new ArrayList<>();
	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String addUser() {
		User user = new User();
		user.name = loginName;
		user.password = password;
		getServiceProvider().getUserService().addUser(user);

		return INPUT;
	}

	public String list() {
		errMap.put("msg", "jsp获取Action的 map value、");
		message = "jsp直接获取Action属性、";
		user = new User();
		user.setName("jsp获取Action对象的属性、");

		userList.addAll(getServiceProvider().getUserService().getAllUsers());
		return SUCCESS;
	}
	
	public String userListApi(){
		userList.addAll(getServiceProvider().getUserService().getAllUsers());
		result.put("msg", "hello world");
		result.put("list", userList);
		
		return SUCCESS;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<User> getUserList() {

		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getA() {
		return "jsp直接访问Action普通方法,";
	}
}
