package days07;

public class Member {
	private String id;
	private String name;
	private int age;
	private String addr;
	private String tel;
	public Member(String id, String name, int age, String addr, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.tel = tel;
	}
	public Member() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
	
}
