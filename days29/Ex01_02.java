package days29;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author kenik
 * @date 2022. 3. 30. - 오전 5:56:30
 * @subject 
 * @content 
 */
public class Ex01_02 {

	public static void main(String[] args) { 
		/*

		String fileName = ".\\src\\days29\\member.txt";
		
	   // 멤버 객체 를 파일에 저장    
		Member m1 = new Member("박단", 25, false, 2);
		//m1.writeExternal(fileName); 
		
		// 파일 -> 멤버 객체 읽기
		Member m =  m1.readExternal(fileName);
		System.out.println( m );

		System.out.println("END");
		
		// 객체를 직렬화 하고 역직렬화하는 방법 ( 직접 구현 X )
		// ObjectInputStream, ObjectOutputStream 스트림 클래스 존재 +  사용 방법 숙지 
		 *
		 */
	} // main

} // class

/*
class Member{
	
	// field
	private String name;
	private int age;
	private boolean gender;
	private long type;
	
	// contructor
	public Member() {}

	public Member(String name, int age, boolean gender, long type) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.type = type;
	}

	// getter, setter
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

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("%s,%d,%b,%d", name, age, gender, type);
	} 
	
	// 멤버 객체를 파일 저장하는 메서드
	public void writeExternal(String fileName) {
			try (FileWriter fw = new FileWriter(fileName );
					BufferedWriter bw = new BufferedWriter(fw)) {
					 
				          bw.write(this.name+"\n");
				          bw.write(this.age+"\n");
				          bw.write(this.gender+"\n");
				          bw.write(this.type+"\n");
						
				          System.out.println("> 객체 저장 완료!!!");
					} catch (Exception e) {
						e.printStackTrace();
					}
	}
	
	// 파일  -> 멤버 객체 반환하는 메서드 
	public Member readExternal( String fileName ) {
		Member m = null;
		
		try ( FileReader fr = new FileReader(fileName );
       		 BufferedReader br = new BufferedReader(fr)) {
		  
	        		 String name = br.readLine();
	        		 int age =  Integer.parseInt(br.readLine() );
	        		 boolean gender =  Boolean.parseBoolean( br.readLine() );
	        		 long type = Long.parseLong(br.readLine());
	        		 
       		  m = new Member(name, age, gender, type); 
       		  
       		 return m; 
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}
	}
	
} // class
*/




 