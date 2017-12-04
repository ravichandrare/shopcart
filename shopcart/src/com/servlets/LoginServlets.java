package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.services.CartServices;
import com.services.LoginServices;

public class LoginServlets extends HttpServlet {
	
	private static final long serialVersionUID = 7658192772554535814L;
	private CartServices cartService;
	private LoginServices loginservices;
	

	@Override
	public void init() throws ServletException {
		loginservices = new LoginServices();
		cartService = new CartServices();
		
	}
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page=StringUtils.trimToNull(req.getParameter("page"));
		String action=StringUtils.trimToNull(req.getParameter("action"));
		
		String nextpage="/login.jsp";
	
		if(page!=null)
		{
			if(StringUtils.equalsAnyIgnoreCase("login", page))
			{
				if(StringUtils.equalsAnyIgnoreCase("Login", action));
				{
					String username=StringUtils.trimToNull(req.getParameter("username"));
					String password=StringUtils.trimToNull(req.getParameter("password"));
					
					boolean isvalid;
					try {
						isvalid = loginservices.authenticate(username,password);
						if(isvalid) {
							nextpage="/cart.jsp";
							req.setAttribute("products",cartService.getproducts());
							HttpSession se=req.getSession(true);
						}
						else
						{
							nextpage="/login.jsp";
							req.setAttribute("loginerror", "Invalid username or passwaord");
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
			}
		}
		
		 RequestDispatcher rd= req.getRequestDispatcher(nextpage);
		 rd.forward(req, resp);
	}

	@Override
	public void destroy() {
	
	}

	

}
