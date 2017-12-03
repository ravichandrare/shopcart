package com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cart.beans.Products;
import com.shoping.dao.ConnectionUtil;

public class CartServices {
	
	public List<Products> getproducts() throws ClassNotFoundException, SQLException
	{
		
		Connection con = ConnectionUtil.getConnection();
		
		ArrayList<Products> prod = new ArrayList<Products>();
		PreparedStatement st = con.prepareStatement("Select * from products;");
		ResultSet rs =st.executeQuery();
		while(rs.next()) {
			Products p = new Products();
			int id=rs.getInt("id");
			String name = rs.getString("name");
			Double price = rs.getDouble("price");
			
			p.setId(id);
			p.setName(name);
			p.setPrice(price);
			
			prod.add(p);
		}
		
		return prod;
	}

}
