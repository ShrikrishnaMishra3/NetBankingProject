package com.jsp.netbanking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class loginServlet extends HttpServlet {
	
	          @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	      PrintWriter out=resp.getWriter();
	      String username=req.getParameter("Username");
	      String password=req.getParameter("Password");
	      
 try {
			Driver ref = new Driver();
			DriverManager.registerDriver(ref);
			
	       String dburl1="jdbc:mysql://localhost:3306/Mybank?user=root&password=root";
	       Connection con= DriverManager.getConnection(dburl1);
			
	       String query ="Select Username,Password from  signin where Username=?";
	       PreparedStatement pstmt = con.prepareStatement(query);
	       pstmt.setString(1,username);
	       ResultSet res=pstmt.executeQuery(query);
	       while(res.next())
	       {
	    	   
	    	   String uname=res.getString("Username");
	    	   String pword=res.getString("Password");
	       }
			
				
		} catch (SQLException e) {
			
		
		}
	
}
	
}

