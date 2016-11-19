package com.sgm.implement;

import com.sgm.dao.BookDao;
import com.sgm.service.BookService;

public class BookServiceImp implements BookService{
	
	private BookDao bookDao;
	
	@Override
	public void printMsg() {
		System.out.println("book print");
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}
