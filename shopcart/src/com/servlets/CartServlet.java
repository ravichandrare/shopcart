package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.services.CartServices;

public class CartServlet extends HttpServlet {

	private CartServices cartService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession se=req.getSession(true);
		String nextpage="/cart.jsp";
		String actionname = req.getParameter("action");
		if (StringUtils.equalsAnyIgnoreCase("Add To Cart", actionname)) {
			
			nextpage = "/cart.jsp";
			
			try {
				req.setAttribute("products",cartService.getproducts());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (StringUtils.equalsAnyIgnoreCase("CheckOut", actionname)) {
			nextpage = "/login.jsp";
		}
		RequestDispatcher rd = req.getRequestDispatcher(nextpage);
		rd.forward(req, resp);

	}

	@Override
	public void destroy() {

	}

	@Override
	public void init() throws ServletException {
		cartService = new CartServices();
	}

}
