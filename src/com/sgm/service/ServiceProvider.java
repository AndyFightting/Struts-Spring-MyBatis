package com.sgm.service;

public class ServiceProvider {

	// ---各个Service接口对象放这里，而Service接口的实例对象通过Spring配置文件注入
	// 每个Service对象必须有 get set 方法, get 用于获取，set 用于Spring注入

	private UserService userService;
	private BookService bookService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
}
