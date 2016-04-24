package com.hsx.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsx.domain.Book;
import com.hsx.domain.Cart;
import com.hsx.domain.MyConstant;
import com.hsx.service.BookService;
import com.hsx.service.impl.BookServiceImpl;

/**
 * 购买的控制器
 * @author hsx
 *
 */
public class BuyBookServlet extends HttpServlet {
	
	private BookService bookService = new BookServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bookId = request.getParameter("bookId");
		
		// 获取购物车
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute(MyConstant.BOOK_CART);
		
		Book book = bookService.findBookById(bookId);
		
		if (cart == null) {//没有购物车，创建一个，并放入session中
			cart = new Cart();
			cart.addBook(book);
			session.setAttribute(MyConstant.BOOK_CART, cart);
		}
		else { // 有购物车，直接把书放到购物车中
			cart.addBook(book);
		}
		
		// 转向购物车列表
		request.getRequestDispatcher("/WEB-INF/pages/listCart.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
