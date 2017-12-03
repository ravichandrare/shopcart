package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.services.LoginServices;

public class HelpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 7658192772554535814L;
	private LoginServices loginservices;

	@Override
	public void init() throws ServletException {
		loginservices=new LoginServices();
	}
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page=StringUtils.trimToNull(req.getParameter("help"));
		String action=StringUtils.trimToNull(req.getParameter("helpaction"));
		
		//String nextpage="/login.jsp";
		String nextpage = null;
	
		if(page!=null)
		{
			if(StringUtils.equalsAnyIgnoreCase("Help", page))
			{
				if(StringUtils.equalsAnyIgnoreCase("Help", action));
				{	
					nextpage = "/Help.jsp";
					
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
