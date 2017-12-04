package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class LogoutServlet extends HttpServlet {
	String nextpage="/login.jsp";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=StringUtils.trimToNull(req.getParameter("action"));
		if(StringUtils.equalsAnyIgnoreCase("Logout", action)) {
			req.getSession().invalidate();
			nextpage ="/login.jsp";
		}
		RequestDispatcher rd = req.getRequestDispatcher(nextpage);
		rd.forward(req, resp);
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() throws ServletException {
		
	}

}
