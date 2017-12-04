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

public class CheckoutServlet extends HttpServlet{

	private CartServices cartService;
	private static final long serialVersionUID = -3702569125659133654L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page=StringUtils.trimToNull(req.getParameter("page"));
		String action=StringUtils.trimToNull(req.getParameter("action"));
		String nextpage = "/cart.jsp";
		if(StringUtils.equalsAnyIgnoreCase("checkout1", page))
		{
			if(StringUtils.equalsAnyIgnoreCase("back to cart", action))
			{
				nextpage="/cart.jsp";
				
				try {
					req.setAttribute("products",cartService.getproducts());
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(StringUtils.equalsAnyIgnoreCase("checkout", action)) {
				HttpSession se=req.getSession(true);
				se.invalidate();
				nextpage="/thankyou.jsp";
				
			}
		}
		 RequestDispatcher rd= req.getRequestDispatcher(nextpage);
		 rd.forward(req, resp);
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() throws ServletException {
		
		cartService=new CartServices();
	}
	
	
	

}
