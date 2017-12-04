package com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;

import com.shoping.dao.ConnectionUtil;

public class LoginServices {
	
	public boolean authenticate(String username,  String password) throws ClassNotFoundException, SQLException
	{												
		Connection con=ConnectionUtil.getConnection();
		String ps = null;
		if(username!=null&&password!=null) {
		PreparedStatement st=con.prepareStatement("select password from logins where username=?");
		st.setString(1, username);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			ps=rs.getString("password");
		}
		
		
		if(StringUtils.equalsAnyIgnoreCase(ps,password ))
		{
			return true;
		}
		}
		return false;
		
	}

}
