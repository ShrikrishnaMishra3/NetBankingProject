package com.jsp.netbanking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class NEtBanking extends HttpServlet {


	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		    PrintWriter out= resp.getWriter();
		
	        String fname=req.getParameter("FirstName");
	        String mname=req.getParameter("MiddleName");
	        String lname=req.getParameter("LastName");
	        String addd1=req.getParameter("AddressLine1");
	        String addd2=req.getParameter("AddressLine2");
	        String[] str1= req.getParameterValues("Gender");
	        String dob=req.getParameter("DOB");
	        String email=req.getParameter("Email");
	        String phno=req.getParameter("PhoneNo");
	        String cty=req.getParameter("City");
	        String pincode=req.getParameter("Pincode");
            String uname=req.getParameter("Username");
	        String pword=req.getParameter("Password");
	        String rpword=req.getParameter(" RePassword");
	       
	    //  out.println("FirstName="+fname); 
	    //  out.println("MiddleName="+mname);
	   //   out.println("LastName="+lname);
	   //   out.println("Gender="+str1);
	   //   out.println("DOB="+dob);
	   //   out.println("Email="+email);
	   //   out.println("PhoneNo="+phno);
	   //   out.println("City="+cty);
	   //   out.println("Username="+uname);
	   //   out.println("Password="+pword);
	      
	      try {
	       
	            Driver ref = new Driver();
	            DriverManager.registerDriver(ref);
	      
	            String dburl1="jdbc:mysql://localhost:3306/Mybank?user=root&password=root";
	         	Connection con= DriverManager.getConnection(dburl1);
	             String query1="insert into netbanking "+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    		 PreparedStatement pstmt1= con. prepareStatement(query1);
	     
	            String query2="insert into  signin "+"values(?,?)";
	    		 PreparedStatement pstmt2= con. prepareStatement(query2);
			
			pstmt1.setString(1,fname);             
			pstmt1.setString(2, mname);
			pstmt1.setString(3,lname);
			pstmt1.setString(4,addd1);
			pstmt1.setString(5,addd2);
			pstmt1.setString(6,str1[0]);
			pstmt1.setString(7,dob);
			pstmt1.setString(8,email);
			pstmt1.setString(9,phno);
			pstmt1.setString(10,cty);
			pstmt1.setString(11,pincode);
            pstmt1.setString(12,uname);
			pstmt1.setString(13,pword);
			pstmt1.setString(14,rpword);
			
			
			pstmt2.setString(1,uname);
			pstmt2.setString(2,pword);

			 int res1=pstmt1.executeUpdate();
			 int res2=pstmt2.executeUpdate();
			 if(res1!=0 && res2!=0) {
				 System.out.println("profile updated.....");
			 }
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	       
	       
	       
	}  
}
