package days05;

import java.io.Serializable;
import java.util.Date;

// java beans == 자바빈즈 == 자바빈
public class MemberInfo implements Serializable{   // 직렬화
	
	// private 필드 선언
	private String id;
	private String passwd;
	private String name;
	private Date registerDate;
	private String email;
	
	// getter, setter 선언	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	
	
	
}
