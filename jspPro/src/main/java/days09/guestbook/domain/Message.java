package days09.guestbook.domain;

public class Message {
	// fields - 테이블의 칼럼 이름 과 똑같이 맞춰야함 
	   private int message_id;
	   private String guest_name;
	   private String password;
	   private String message;
	   
	   
	   
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public String getGuest_name() {
		return guest_name;
	}
	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	   
	// 추가 -비밀번호가 있는지 
	   public boolean hasPassword() {
	      return password != null && !password.isEmpty();
	   }

	   // 추가 비밀번호가 일치하는지 
	   public boolean matchPassword(String password) {
	      return this.password != null && this.password.equals(password);
	   }
}
