package com.hsx.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsx.domain.Cart;
import com.hsx.domain.CartItem;
import com.hsx.domain.MyConstant;

/**
 * 修改购买书籍的数量
 * @author hsx
 *
 */
public class ChangeNumServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 得到请求参数bookId和新的数量num
		String bookId = request.getParameter("bookId");
		String num = request.getParameter("num");
		int newNum = 0;
		try {
			newNum = Integer.parseInt(num);
		} catch (Exception e) {
			// 用户输入错误的数值，提示用户
			request.setAttribute("message", "数量请输入数字");
			request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
			return;
		}
		
		// 得到购物车
		Cart cart = (Cart) request.getSession().getAttribute(MyConstant.BOOK_CART);
		// 根据bookId获取购物项
		CartItem cartItem = cart.getMap().get(bookId);
		// 修改购物项中的num
		cartItem.setNum(newNum);
		// 转向listCart.jsp页面
		request.getRequestDispatcher("/WEB-INF/pages/listCart.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
