package com.jsp.netbanking;
import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.mysql.jdbc.Driver;

import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
 
 
public class Mybank extends HttpServlet //throws ServletException, IOException
{
 
    DecimalFormat myFormat = new DecimalFormat("$#,000.00");
 
 
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
        
	   
		
        String amt=request.getParameter("Amount");
		String bal=request.getParameter("Balance");
        String dep=request.getParameter("Deposit");
        String with=request.getParameter("Withdraw");
        String uname=request.getParameter("Username");
        String pword=request.getParameter("Password");
      
      
      try {
       
            Driver ref = new Driver();
            DriverManager.registerDriver(ref);
      
            String dburl1="jdbc:mysql://localhost:3306/Mybank?user=root&password=root";
         	Connection con= DriverManager.getConnection(dburl1);
             String query1="insert into bank "+"values(?,?,?,?,?,?)";
    		 PreparedStatement pstmt1= con. prepareStatement(query1);
     
            String query2="insert into  signin "+"values(?,?)";
    		 PreparedStatement pstmt2= con. prepareStatement(query2);
        pstmt1.setString(1,amt); 
		pstmt1.setString(2,bal);             
		pstmt1.setString(3, dep);
		pstmt1.setString(4,with);
        pstmt1.setString(5,uname);
		pstmt1.setString(6,pword);
		
		
		pstmt2.setString(1,uname);
		pstmt2.setString(2,pword);

		 int res1=pstmt1.executeUpdate();
		 int res2=pstmt2.executeUpdate();
		 if(res1!=0 && res2!=0) {
			 System.out.println("Complete.....");
		 }
		
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
       
       
       
}  
 
 
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        //Makes instance variable a local variable
 
        //Set MIME type of content returned to browser
        HttpSession session = request.getSession();
 
        response.setContentType("text/html");
 
        PrintWriter out = response.getWriter();
 
 
        //Starts outputting the HTML Form
 
 
 
        //Decides which action to take
 
 
        double accBalance = 0.0;
        Double savedBalance = (Double)session.getAttribute("accBalance");
 
        if (savedBalance != null)
        {
            accBalance = savedBalance.doubleValue();
        }
 
        String action = request.getParameter("act");
 
        if(action != null)
        {
            if(action.equals("Deposit"))
            {
                double amount;
                String strAmount = request.getParameter("Amount");
                try
                {
                amount = Double.parseDouble(strAmount);
 
                  if(amount <= 0.00)
                  {
                     //Output error HTML Page
                     out.println("<html>");
                     out.println("<head>");
                     out.println("<title>Invalid Input</title>");
                     out.println("</head>");
                     out.println("<body>");
                     out.println("");
                     out.println("<h3>Invalid Input</h3>");
                     out.println("<p>Please note that if you are seeing this page it means that you have attempted to Deposit a invalid amount!!<br/>Below is a list of invalid inputs</p>");
                     out.println("<ul>");
                     out.println("<li>Blank or null values</li>");
                     out.println("<li>Negative Numbers</li>");
                     out.println("<li>Words or Letters </li>");
                     out.println("<li>Special charaters</li>");
                     out.println("</ul>");
                     out.println("<br/>");
                     out.println("<h3>Sugestions</h3>");
                     out.println("<p>Inorder to avoid seeing this error page again please only input numbers and avoid inputing the above listed input types</p>");
                  }
                  else
                  {
                   accBalance = accBalance + amount;
 
 
                    session.removeAttribute("accBalance");
                    session.setAttribute("accBalance",new Double(accBalance));
                    
                    session.setAttribute("forwardTo","bank.jsp");
 
 
 
                  //out.println("<br><center>Balance:"+myFormat.format(accBalance)+" </center> <br>");
                  }
                  }
              catch(NumberFormatException ex)
                {
                    //Output error HTML Page
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Invalid Input</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("");
                    out.println("<h3>Invalid Input</h3>");
                    out.println("<p>Please note that if you are seeing this page it means that you have attempted to Deposit a invalid amount!!<br/>Below is a list of invalid inputs</p>");
                    out.println("<ul>");
                    out.println("<li>Blank or null values</li>");
                    out.println("<li>Negative Numbers</li>");
                    out.println("<li>Words or Letters </li>");
                    out.println("<li>Special charaters</li>");
                    out.println("</ul>");
                    out.println("<br/>");
                    out.println("<h3>Sugestions</h3>");
                    out.println("<p>Inorder to avoid seeing this error page again please only input numbers and avoid inputing the above listed input types</p>");
                }
            }
            else if(action.equals("Withdraw"))
            {
 
                double amount;
                String strAmount = request.getParameter("Amount");
                try
                {
                    amount = Double.parseDouble(strAmount);
 
 
                if(amount <= 0.00)
                {
                    //Output error HTML Page
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Invalid Input</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("");
                    out.println("<h3>Invalid Input</h3>");
                    out.println("<p>Please note that if you are seeing this page it means that you have attempted to Withdraw a invalid amount!!<br/>Below is a list of invalid inputs</p>");
                    out.println("<ul>");
                    out.println("<li>Blank or null values</li>");
                    out.println("<li>Negative Numbers</li>");
                    out.println("<li>Words or Letters </li>");
                    out.println("<li>Special charaters</li>");
                    out.println("</ul>");
                    out.println("<br/>");
                    out.println("<h3>Sugestions</h3>");
                    out.println("<p>Inorder to avoid seeing this error page again please only input numbers and avoid inputing the above listed input types</p>");
 
                }
               else
                {
                    accBalance = accBalance - amount;
 
                    session.removeAttribute("accBalance");
                    session.setAttribute("accBalance",new Double(accBalance));
 
                    session.setAttribute("forwardTo","bank.jsp");
                   // out.println("<br><center>Balance:"+myFormat.format(accBalance)+" </center> <br>");
 
                }
                }
                catch(NumberFormatException ex)
                {
                    //Output error HTML Page
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Invalid Input</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("");
                    out.println("<h3>Invalid Input</h3>");
                    out.println("<p>Please note that if you are seeing this page it means that you have attempted to Withdraw a invalid amount!!<br/>Below is a list of invalid inputs</p>");
                    out.println("<ul>");
                    out.println("<li>Blank or null values</li>");
                    out.println("<li>Negative Numbers</li>");
                    out.println("<li>Words or Letters </li>");
                    out.println("<li>Special charaters</li>");
                    out.println("</ul>");
                    out.println("<br/>");
                    out.println("<h3>Sugestions</h3>");
                    out.println("<p>Inorder to avoid seeing this error page again please only input numbers an avoid inputing the above listed input types</p>");
 
                }
            }
            else if(action.equals("Balance"))
            {
                session.setAttribute("forwardTo","bank.jsp");
                //out.println("<br><center>Balance:"+myFormat.format(accBalance)+" </center> <br>");
            }
            else
            {   session.setAttribute("forwardTo","bank.jsp");
                //out.println("<br><center>Balance:"+myFormat.format(accBalance)+" </center> <br>");
            }
        }
        else
        {
            session.setAttribute("forwardTo","bank.jsp");
            //out.println("<br><center>Balance:"+myFormat.format(accBalance)+" </center> <br>");
        }
 
 
        session.removeAttribute("accBalance");
        session.setAttribute("accBalance",new Double(accBalance));
 
    }
 
}//end


       