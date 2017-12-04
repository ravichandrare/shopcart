package com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cart.beans.CheckoutValues;
import com.shoping.dao.ConnectionUtil;

public class CheckoutServices {
	
	public List<CheckoutValues> getCompleteValues(String[] ids,String[] quant) throws ClassNotFoundException, SQLException{
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps;
		CheckoutValues cval;
		ArrayList<CheckoutValues> selectedlist =new ArrayList<CheckoutValues>();
		for(int i=0;i<ids.length;i++){
		int id = Integer.parseInt(ids[i]);	
		int qty=Integer.parseInt(quant[i]);
		
		ps=con.prepareStatement("select * from products where id=?;");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		String name = null;
		double price = 0;
		while(rs.next()) {
			name = rs.getString("name");
			price = rs.getDouble("price");
		}
		cval=new CheckoutValues();
		cval.setId(id);
		cval.setName(name);
		cval.setPrice(price);
		cval.setQuantity(qty);
		selectedlist.add(cval);
		
		}
		
		return selectedlist;
	}
	
}
