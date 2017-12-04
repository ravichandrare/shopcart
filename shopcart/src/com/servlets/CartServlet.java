package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.cart.beans.CheckoutValues;
import com.services.CartServices;
import com.services.CheckoutServices;

public class CartServlet extends HttpServlet {

	private CartServices cartService;
	private CheckoutServices checkoutService;
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
		ArrayList<CheckoutValues> val=new ArrayList<CheckoutValues>();
		if (StringUtils.equalsAnyIgnoreCase("Add To Cart", actionname)) {
		
			String[] ids= req.getParameterValues("id");
			String[] quant = req.getParameterValues("quantity");
			List<String> list = new ArrayList<String>();
			
			for(String s :quant)
			{
				if(s!=null&&s.length()>0) {
					list.add(s);
				}
			}
			quant=list.toArray(new String[list.size()]);
			try {
				val=(ArrayList<CheckoutValues>) checkoutService.getCompleteValues(ids, quant);
			} catch (ClassNotFoundException | SQLException e1) {
				
			}
			se.setAttribute("selectedlist", val);
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
			
			nextpage = "/checkout.jsp";
			se.getAttribute("selectedlist");
					
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
		checkoutService = new CheckoutServices();
	}

}
