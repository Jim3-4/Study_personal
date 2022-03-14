package days17;

/**
 * @author 지민
 * @date 2022. 3. 14. - 오후 2:13:18
 * @subject 
 * @content 
 * 
 */
public class Employee {
//필드 
	private String name;
	private String addr;
	private String tel;
	private String hiredate;
//생성자
	public Employee() {
		System.out.println("employee 디폴트 생성자 호출 됨 ");
	}
//메소드 

public Employee(String name, String addr, String tel, String hiredate) {

	this.name = name;
	this.addr = addr;
	this.tel = tel;
	this.hiredate=hiredate;
	System.out.println("생성자4개 호출됨 ");
}

public void dispEmpInfo() {
	System.out.printf("사원명: %s, 주소: %s, 연락처:%s, 입사날짜 :%s\n", 
			this.name, this.addr, this.tel, this.hiredate);
}

/**
 * @return the name
 */
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

/**
 * @return the addr
 */
public String getAddr() {
	return addr;
}

public void setAddr(String addr) {
	this.addr = addr;
}

/**
 * @return the tel
 */
public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}

/**
 * @return the hiredate
 */
public String getHiredate() {
	return hiredate;
}

public void setHiredate(String hiredate) {
	this.hiredate = hiredate;
}
}
