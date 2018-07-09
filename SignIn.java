package com.regist;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.ConnectionProv;

public class SignIn extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter op= response.getWriter();
		String uemail=request.getParameter("uemail");
		String upswrd=request.getParameter("upswrd");
		
		Connection connect=ConnectionProv.getConnect();
		try {
			PreparedStatement ps = connect.prepareStatement("select * from register where email=? and pswrd=?");
			ps.setString(1, uemail);
			ps.setString(2, upswrd);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				//response.sendRedirect("welcome.html");
				RequestDispatcher rd=request.getRequestDispatcher("welcome.html");
				rd.forward(request, response);//it will redirect us into new page*/
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				op.println("email or password is not correct");
				rd.include(request, response);//we have to show login error in current page only
			}
		    }
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}

}
