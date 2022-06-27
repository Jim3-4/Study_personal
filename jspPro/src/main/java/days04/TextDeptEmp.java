package days04;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBconn;

import days02.DeptDTO;
import days02.EmpDTO;

/**
 * Servlet implementation class TextDeptEmp
 */
@WebServlet("/test/test00.htm")
public class TextDeptEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TextDeptEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "select deptno, dname, loc "
                + " from dept"; 

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null; 
    ArrayList<DeptDTO> deptList = null; 
     
    DeptDTO dto = null; 

    int deptno;
    String dname, loc;

    con = DBconn.getConnection();
    try {
       pstmt = con.prepareStatement(sql);
       rs = pstmt.executeQuery();          

       if (rs.next()) {
          deptList = new ArrayList<DeptDTO>();
          do {
                deptno =  rs.getInt("deptno");   
                dname =  rs.getString("dname");  
                loc = rs.getString("loc");       
             dto = new DeptDTO(deptno, dname, loc); 

             deptList.add(dto);
           } while (rs.next());
       } // if
    } catch (SQLException e) { 
       e.printStackTrace();
    } finally {
       try {
          rs.close();
          pstmt.close(); 
       } catch (SQLException e) {
          e.printStackTrace();
       }
    }// try
    
     
    ArrayList<EmpDTO> empList = null;
    
    String pDeptno = request.getParameter("deptno");
    deptno =pDeptno==null? 10:Integer.parseInt(pDeptno); 
    //넘어오는 값 없음 기본 값 10
    
    sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno "
          + " from emp "
          +" where deptno = ?" ;
    try {
       pstmt = con.prepareStatement(sql);
       pstmt.setInt(1,  deptno);
       rs = pstmt.executeQuery();
       EmpDTO empDto = null;

       if (rs.next()) {
          empList = new ArrayList<EmpDTO>();
          do {
             empDto = new EmpDTO( rs.getInt("empno")
                                               , rs.getString("ename")
                                               , rs.getString("job")
                                               , rs.getInt("mgr")
                                               , rs.getDate("hiredate")
                                               , rs.getDouble("sal")
                                               , rs.getDouble("comm")
                                               , rs.getInt("deptno"));       

             empList.add(empDto);
           } while (rs.next());
       } // if
    } catch (SQLException e) { 
       e.printStackTrace();
    } finally {
       try {
          rs.close();
          pstmt.close();
          DBconn.close();
       } catch (SQLException e) {
          e.printStackTrace();
       }
    }// try
    
    // 
    request.setAttribute("deptList", deptList);
    request.setAttribute("empList", empList);
    
    String pdeptno=request.getParameter("deptno");
    if(pdeptno ==null || pdeptno.equals("")) {
    	pdeptno="10";
    }
    
    
    
	//	request.setAttribute("name", response);
		//포워딩 //리다이렉트
		//이렇게 쓰면 /jspPro/test/ex01_forward.jsp
		//String path="ex01_forward.jsp"; //자원을 찾을 수 없을때 404 오류 
		String path="/days04/ex01_forward.jsp"; 
		RequestDispatcher dispatcher=request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
