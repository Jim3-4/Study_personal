package days02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class info
 */
@WebServlet(
		description = "@WebServlet 어노테이션 사용 자동 서블릿 등록 예제", 
		urlPatterns = { 
				"/info", 
				"/days02/info.htm"
		})
public class info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		
		response.getWriter()
			.append("Get 방식 요청 : ")
			.append(request.getContextPath())
			.append(">이름:"+name+"<br>")
			.append(">나이:"+age+"<br>");
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//[] -> utf-8 -.> utf-8[WAS 톰캣(웹 컨테이너)] ->text/html utf-8
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		
		response.getWriter()
		.append("Post 방식 요청 : ")
		.append(request.getContextPath())
		.append(">이름:"+name+"<br>")
		.append(">나이:"+age+"<br>");
	}

}
