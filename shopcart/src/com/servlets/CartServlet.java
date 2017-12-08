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

	private static final long serialVersionUID = 6551018637577762972L;
	private CartServices cartService;
	private CheckoutServices checkoutService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession se = req.getSession(true);
		String nextpage = "/cart.jsp";
		String actionname = req.getParameter("action");
		ArrayList<CheckoutValues> val = new ArrayList<CheckoutValues>();
		try {
			if (StringUtils.equalsAnyIgnoreCase("Add To Cart", actionname)) {

				String[] ids = req.getParameterValues("id");
				String[] quant = req.getParameterValues("quantity");

				if (ids.length==0 || quant.length==0) {
					nextpage = "/login.jsp";
				}

				List<String> list = new ArrayList<String>();

				for (String s : quant) {
					if (s != null && s.length() > 0) {
						list.add(s);
					}
				}
				quant = list.toArray(new String[list.size()]);
				val = (ArrayList<CheckoutValues>) checkoutService.getCompleteValues(ids, quant);

				se.setAttribute("selectedlist", val);
				nextpage = "/cart.jsp";
				req.setAttribute("products", cartService.getproducts());

			} else if (StringUtils.equalsAnyIgnoreCase("CheckOut", actionname)) {

				nextpage = "/checkout.jsp";
				se.getAttribute("selectedlist");

			}
			
			RequestDispatcher rd = req.getRequestDispatcher(nextpage);
			rd.forward(req, resp);
			
		} catch (NullPointerException | ClassNotFoundException | SQLException | ArrayIndexOutOfBoundsException ne) {
			String nextpage1 = "/cart.jsp";
			try {
				req.setAttribute("products", cartService.getproducts());
				nextpage1 = "/cart.jsp";
			} catch (ClassNotFoundException | SQLException | NullPointerException e) {
				e.printStackTrace();
			}
			req.setAttribute("addtocarterror", "Please select one or more items");
			RequestDispatcher rd = req.getRequestDispatcher(nextpage1);
			rd.forward(req, resp);
		}
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
