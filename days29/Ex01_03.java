package days29;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author kenik
 * @date 2022. 3. 30. - 오전 5:56:30
 * @subject 
 * @content 
 *      // 객체를 직렬화 하고 역직렬화하는 방법 ( 직접 구현 X )
		// ObjectInputStream, ObjectOutputStream 스트림 클래스 존재 +  사용 방법 숙지 
 */
public class Ex01_03 {

	public static void main(String[] args) { 
		// 10:05 수업 시작~

		String fileName = ".\\src\\days29\\member.dat"; 
		 Member m1 = new Member("박단", 25, false, 2);
		
		// m1 객체를 직렬화 해서 파일 저장.
		// 보조스트림
 
		try (
				// 바이트 스트림
				FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos) ){
			
			     // 예외 발생 : java.io.[NotSerializableException]: days29.Member
			     oos.writeObject( m1 );  // writeObject( 객체 )  쓰기, 저장, 전송
			     
		} catch (Exception e) {
			e.printStackTrace();
		} // try
 
		
		
		// 파일 -> 스트림-> 객체 변환(  역직렬화 )
		try (
				FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);
				){
			   // 다운캐스팅
			      Member m = (Member) ois.readObject();
			     
			      System.out.println(  m );
			      //p 939
			      // transient 키워드 사용한다. 
			      // 박단,25,false,0  type 필드는 직렬화 대상에서 제외되었기에  0 ( 기본값 )
			      
		} catch (Exception e) {
			e.printStackTrace();
		} // try

		System.out.println("END");
		 
	} // main

} // class

// [ 직렬화가 가능한 클래스 선언 ]
// 1. implements Serializable 빈 인터페이스
// 2.  implements Externalizable   X  
//            writeExternal() 직접 구현
//            readExternal()    직접 구현
class Member implements Serializable{
    // 시리얼 버전 UID
	private static final long serialVersionUID = 2336313051081995427L;
	
	// field
	private String name;
	private int age;
	private boolean gender;
	private transient long type;   // 직렬화 제외 = 객체-> 스트림
	
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
	
	 
} // class

class Person implements Externalizable{
	
	String name;
	int age;
	
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
	
	
}





 