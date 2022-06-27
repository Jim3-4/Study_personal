package days02;

//DTO ==VO
public class DeptDTO {

	//getter,setter, toString 단축키
	//Alt + Shift + S
	
	private int deptno;
	private String dname;
	private String loc;
	
	//constructor
	public DeptDTO() {
		super();
	}
	

	public DeptDTO(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	public int getDeptno() {
		return deptno;
	}
	
	//getter,setter
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}


	@Override
	public String toString() {
		return String.format("%d\t%s\t%s", deptno,dname,loc);
		//return "DeptDTO [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}


	
	
	
	
}//class
