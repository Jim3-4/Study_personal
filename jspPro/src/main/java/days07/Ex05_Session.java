package days07;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ex05_Session
 */
@WebServlet("/days07/ex05.htm")
public class Ex05_Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex05_Session() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("doget호출");	
	//jsp 페이지에서 세션을 사용하는 방법 ? jsp기본객체 session
	//서블릿에서 세션을 사용하는 방법 ? request.getSession()메서드 

//차이점
//request.getSession(); 세션이존재하지 않으면 새로운 세션 객체를 생성해서 반환
//,request.getSession(false); 세션이 존재하지 않으면 null반환

HttpSession session=request.getSession(false);
if(session!=null) {
	int deptno=(int)session.getAttribute("deptno");
	System.out.println(deptno);
}else {
	System.out.println("x");
}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
}

}
