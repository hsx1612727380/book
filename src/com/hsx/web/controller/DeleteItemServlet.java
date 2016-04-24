package com.hsx.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsx.domain.Cart;
import com.hsx.domain.MyConstant;

/**
 * 删除的控制器
 * @author hsx
 *
 */
public class DeleteItemServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 得到要删除书的Id
		String bookId= request.getParameter("bookId");
		// 得到购物车
		Cart cart = (Cart) request.getSession().getAttribute(MyConstant.BOOK_CART);
		// 从购物车中删除
		cart.deleteCartItem(bookId);
		// 转向之前的页面listCart.jsp
		request.getRequestDispatcher("/WEB-INF/pages/listCart.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
