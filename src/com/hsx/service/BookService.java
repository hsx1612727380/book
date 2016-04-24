package com.hsx.service;

import java.util.Map;

import com.hsx.domain.Book;

/**
 * 书的具体逻辑具体实现[接口]
 * @author hsx
 *
 */
public interface BookService {

	/**
	 * 获取所有的书籍 Map对象
	 * @return
	 */
	public Map<String, Book> findAllBooks();
	
	/**
	 * 根据书的Id查询这本书的详细信息
	 * @param bookId
	 * @return
	 */
	public Book findBookById(String bookId);
	
}
