package days02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Now extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet( reqest, response);
	}

	@Override
	protected void doPost(HttpServletRequest  reqest, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost( reqest, response);
	}

	@Override
	protected void service(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>2022. 6. 15.-오전 9:57:24</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("</body>");
		out.println("</html>");
		
		   Date now = new Date();

		      String pattern = "yyyy-MM-dd hh:mm:ss";
		      SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		      String strNow=  sdf.format(now);
		      
		      out.println("현재 날짜, 시간:"+ strNow);
		      out.println("</body>");
		      out.println("</html>");
		      
		    
		    		  
	}

}
