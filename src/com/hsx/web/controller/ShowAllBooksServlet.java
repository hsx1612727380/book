package com.hsx.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsx.domain.Book;
import com.hsx.service.BookService;
import com.hsx.service.impl.BookServiceImpl;

/**
 * 转发到显示所有书籍的页面
 * @author hsx
 *
 */
public class ShowAllBooksServlet extends HttpServlet {

	private BookService bookService = new BookServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 得到所有的书
		Map<String, Book> books = bookService.findAllBooks();
		// 将得到的书封装
		request.setAttribute("books", books);
		// 转向显示的页面listBooks.jsp
		request.getRequestDispatcher("/WEB-INF/pages/listBooks.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
