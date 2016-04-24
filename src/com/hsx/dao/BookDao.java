package com.hsx.dao;

import java.util.Map;

import com.hsx.domain.Book;

/**
 * Dao层[接口]
 * @author hsx
 *
 */
public interface BookDao {

	/**
	 * 返回所有书的对象 Map对象
	 * @return
	 */
	public Map<String, Book> findAllBookss();
	
	/**
	 * 根据书的Id查询这本书的详细信息
	 * @param bookId
	 * @return
	 */
	public Book findBookById(String bookId);
	
}
