package com.regist;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.ConnectionProv;

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter op= response.getWriter();
		String ufname=request.getParameter("ufname");// we get uname from html name element and store it into a string uname
		String usname=request.getParameter("usname");
		String uemail=request.getParameter("uemail");
		String upswrd=request.getParameter("upswrd");
		String umobile=request.getParameter("umobile");
//System.out.println(ufname+" "+usname+" "+uemail+" "+upswrd+" "+umobile);
		op.println("data taken in String");
		
		//op.println(ConnectionProv.getConnect());
		
		Connection connect=ConnectionProv.getConnect();
		try {
			PreparedStatement ps=connect.prepareStatement("insert into register values (?,?,?,?,?)");
			ps.setString(1,ufname);
			ps.setString(2, usname);
			ps.setString(3, uemail);
			ps.setString(4, upswrd);
			ps.setString(5, umobile);
			try {
			int x=ps.executeUpdate();
			
			
			   if (x>0)
			   {
				RequestDispatcher rd = request.getRequestDispatcher("welcome.html");
				rd.forward(request, response);
			   }
			
			   }
		    catch (Exception f)
			   {
				RequestDispatcher rd = request.getRequestDispatcher("newuser.html");
				op.println("User name already Exist");
				rd.include(request, response);
			    }
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	

}
