package days04;

import java.sql.Date;

//LOMBOK
public class DeptEmpSalgradeDTO {
	private int deptno;
	private String dname;
	private int empno;
	private String ename;
	private String job;
	private Date hiredate;
	private double sal;
	private double comm;
	private double pay;
	private int grade;
	
	
	public DeptEmpSalgradeDTO() {
		super();
	}
	
	
	public DeptEmpSalgradeDTO(int deptno, String dname, int empno, String ename, String job, Date hiredate, double sal,
			double comm, double pay, int grade) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.pay = pay;
		this.grade = grade;
	}


	public int getDeptno() {
		return deptno;
	}


	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	public int getEmpno() {
		return empno;
	}


	public void setEmpno(int empno) {
		this.empno = empno;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public Date getHiredate() {
		return hiredate;
	}


	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}


	public double getSal() {
		return sal;
	}


	public void setSal(double sal) {
		this.sal = sal;
	}


	public double getComm() {
		return comm;
	}


	public void setComm(double comm) {
		this.comm = comm;
	}


	public double getPay() {
		return pay;
	}


	public void setPay(double pay) {
		this.pay = pay;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	@Override
	public String toString() {
		return "DeptEmpSalgradeDTO [deptno=" + deptno + ", dname=" + dname + ", empno=" + empno + ", ename=" + ename
				+ ", job=" + job + ", hiredate=" + hiredate + ", sal=" + sal + ", comm=" + comm + ", pay=" + pay
				+ ", grade=" + grade + "]";
	}
	

	
//	@Override
//	public String toString() {
////		return "DeptEmpSalgradeDTO [deptno=" + deptno + ", dname=" + dname + ", empno=" + empno + ", ename=" + ename
////				+ ", job=" + job + ", hiredate=" + hiredate + ", sal=" + sal + ", comm=" + comm + ", pay=" + pay
////				+ ", grade=" + grade + "]";
//		return String.format("%d\t%s\t%d\t%s\t%d", deptno,dname	,mgr,ename,sal);
//	}
	

	
	
	
}//class



//p0001 LG냉장고 2,500,000
//
//작년 1.1		10%
//올해 2.4		15%
//올해 6.1
//
//신한 카드 	5%
