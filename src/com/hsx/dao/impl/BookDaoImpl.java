package com.hsx.dao.impl;

import java.util.Map;

import com.hsx.dao.BookDao;
import com.hsx.domain.Book;
import com.hsx.util.BookDB;

/**
 * Dao层[实现类]
 * @author hsx
 *
 */
public class BookDaoImpl implements BookDao {
	
	/**
	 * 返回所有书的对象 Map对象
	 * @return
	 */
	public Map<String, Book> findAllBookss() {
		return BookDB.getAll();
	}
	
	/**
	 * 根据书的Id查询这本书的详细信息
	 * @param bookId
	 * @return
	 */
	public Book findBookById(String bookId) {
		return BookDB.getBookById(bookId);
	}

}
