package days03;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBconn;
import com.util.DeptDTO;

import days02.EmpDTO;

/**
 * Servlet implementation class ScottEmp
 */
@WebServlet("/scott/emp")
public class ScottEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScottEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.getWriter().append("Served at: ").append(request.getContextPath());

	        String pdeptno = request.getParameter("selDept");

	        String sql = "SELECT * ";
	        sql += "FROM emp ";
	        sql += "WHERE deptno = ? " + pdeptno;
	        sql += "ORDER BY ename ASC";
	        //
	        Connection conn = DBconn.getConnection();
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        int empno;
	        String ename;
	        String job;
	        int mgr;
	        Date hiredate;
	        double sal;
	        double comm;
	        int deptno;
	        EmpDTO dto = null;
	        ArrayList<EmpDTO> list = null;

	        try {
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, Integer.parseInt(pdeptno));
	            rs = pstmt.executeQuery(); 

	            if (rs.next()) {
	                list = new ArrayList<>();
	                do {
	                    empno = rs.getInt("empno");
	                    ename = rs.getString("ename");
	                    job = rs.getString("job");
	                    mgr = rs.getInt("mgr");
	                    hiredate = rs.getDate("hiredate");
	                    sal = rs.getDouble("sal");
	                    comm = rs.getDouble("comm");
	                    deptno = rs.getInt("deptno");
	                    dto = new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);

	                    list.add(dto);
	                } while (rs.next()); // while
	            }
	            pstmt.close();
	            rs.close(); // ***
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        DBconn.close();
	        request.setAttribute("list", list);

      //  String path = "/days03/ex06_emp.jsp";
	        String path = "/days03/ex06_emp_jstl.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
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
