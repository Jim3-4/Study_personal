package prac;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ex01
 */
@WebServlet("/Ex01")
public class Ex01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	String name="홍길동";
	public String getNow() {
		return LocalDateTime.now().toString();
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html: charset=UTF-8");
		Date now=new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
		String strDate=sdf.format(now);
		
		int age=20;
		String today=getNow();
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Insert title here</title>");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"\">");
		out.println("<style>");
		out.println("</style>");
		out.println("<script>");
		out.println("$(document).ready(function (){     });");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("날짜(now) : <input type='text' value='"+ now.toLocaleString() +"'> <br>");
		out.println("이름(name) : <input type='text' value='"+ name +"'> <br>");
		out.println("나이(age) : <input type='text' value='"+age+"'> <br>");
		out.println("날짜(today) : <span>"+today+"</span><br>");
		out.println(strDate +"<br>");
		out.println("</body>");
		out.println("</html>");
		
	}


}
