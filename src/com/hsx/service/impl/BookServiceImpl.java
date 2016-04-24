package com.hsx.service.impl;

import java.util.Map;

import com.hsx.dao.BookDao;
import com.hsx.dao.impl.BookDaoImpl;
import com.hsx.domain.Book;
import com.hsx.service.BookService;

/**
 * 书的具体逻辑具体实现[实现类]
 * @author hsx
 *
 */
public class BookServiceImpl implements BookService {
	
	private BookDao bookDao = new BookDaoImpl();

	/**
	 * 获取所有的书籍 Map对象
	 * @return
	 */
	public Map<String, Book> findAllBooks() {
		return bookDao.findAllBookss();
	}
	
	/**
	 * 根据书的Id查询这本书的详细信息
	 * @param bookId
	 * @return
	 */
	public Book findBookById(String bookId) {
		return bookDao.findBookById(bookId);
	}
 	
}
