package com.regist;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



public class FileUpload extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		try {
			java.util.List<FileItem> multifiles=sf.parseRequest(request);
		 for (FileItem item:multifiles)
		 {
			 item.write(new File("D://Java/Register/UploadedPhoto/"+item.getName()));
			 out.println("File Uploaded Succesfully");
		 }
			
			
		    }
		catch (Exception e)
		{
			System.out.println("Exception" +e.getMessage());
		}
		
	}

}
