package com.hsx.util;

import java.util.LinkedHashMap;
import java.util.Map;

import com.hsx.domain.Book;

/**
 * 建立内存数据库
 * 
 * @author hsx
 * 
 */
public class BookDB {

	
	// Map中存放的是书的Id和Book对象
	private static Map<String, Book> books = new LinkedHashMap<String, Book>();

	/**
	 * 静态加载书籍Book
	 */
	static {
		books.put("ISBN-001", new Book("ISBN-001", "Java编程思想", "小山", 18.3, "Java语言中的经典"));
		books.put("ISBN-002", new Book("ISBN-002", "C/C++编程思想", "李斯", 16.7, "C族中的经典"));
		books.put("ISBN-003", new Book("ISBN-003", "Android入门", "安迪芬", 34.6, "啊啊大沙发"));
		books.put("ISBN-004", new Book("ISBN-004", "看透Spring", "阿大多", 23.4, "啊深V阿道夫"));
		books.put("ISBN-005", new Book("ISBN-005", "JSP/Servlet", "阿达算", 15.7, "阿斯顿发生"));
		books.put("ISBN-006", new Book("ISBN-006", "Struts2", "过户费", 12.5, "阿发乌托邦收费站"));
		books.put("ISBN-007", new Book("ISBN-007", "Hibernate", "粉底霜", 14.6, "阿士大夫大把多人"));
	}
	
	/**
	 * 返回所有的书籍Map对象
	 * @return
	 */
	public static Map<String, Book> getAll() {
		return books;
	}
	
	/**
	 * 根据书籍的Id查询查询本书的详细信息
	 * @param bookId
	 * @return
	 */
	public static Book getBookById(String bookId) {
		return books.get(bookId);
	}
	
}
