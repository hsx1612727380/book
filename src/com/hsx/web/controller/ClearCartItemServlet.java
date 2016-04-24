package com.hsx.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsx.domain.Cart;
import com.hsx.domain.MyConstant;

public class ClearCartItemServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 得到购物车
		Cart cart = (Cart) request.getSession().getAttribute(MyConstant.BOOK_CART);
		// 得到Map对象，清空
		cart.getMap().clear();
		// 转向listCart.jsp页面
		request.getRequestDispatcher("/WEB-INF/pages/listCart.jsp").forward(request, response);
		;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
