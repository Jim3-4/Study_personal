package prac;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class review
 */
@WebServlet("/review")
public class review extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public review() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * @Override protected void service(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * resp.setContentType("text/html; charset=UTF-8"); PrintWriter out
	 * =resp.getWriter(); out.append("service"); }
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * }
	 * 
	 *//**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */@Override
			protected void doPost(HttpServletRequest request, 
				    HttpServletResponse response) throws ServletException, IOException {
				    
						request.setCharacterEncoding("UTF-8"); //추가 (읽어올 때 인코딩)
						response.setContentType("text/html; charset=UTF-8");
						PrintWriter out = response.getWriter();
						String name = request.getParameter("name");
						int age = Integer.parseInt(request.getParameter("age"));
						
						Date now = new Date();
						out.append(String.format(">name:%s <br> >age:%d <br> >now:%s"
				        	, name, age, now.toLocaleString()));
					}
}
