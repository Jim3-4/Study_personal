package days29;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author kenik
 * @date 2022. 3. 30. - 오전 10:31:45
 * @subject 
 * @content 
 */
public class Ex02_03 {

	public static void main(String[] args) throws IOException {
		// 1. 
		// 부모가 직렬화가 가능한 클래스로 선언이 되면
		// 자식은 자동으로 직렬화가 가능한 클래스가 된다.
		 
		// oos.writeObject( c );
		// 2. 부모의 멤버는 직렬화 대상에서 제외 
		//     자식    멤버만 직렬화 대상이 된다. 
		
		// 3. 부모의 직렬화 대상의 제외된 멤버도 직렬화 포함... ?   직접 메서드를 구현...  
		
		try ( FileOutputStream fos = new FileOutputStream(".\\src\\days29\\child.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			Child c = new Child();
			c.name = "admin";
			c.age = 20;
			
			oos.writeObject(c);  // 객체를 직렬화 시켜서 파일 저장.(쓰기)
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.print("> 엔터 치면 계속 하겠다...");
		System.in.read();
		System.in.skip( System.in.available());
		
		// 
		try ( FileInputStream fis = new FileInputStream(".\\src\\days29\\child.dat");
				ObjectInputStream oos = new ObjectInputStream(fis)){
			
			Child c =  (Child) oos.readObject();
			
			System.out.println(  c.name   );   // 출력되면              직렬화 대상에 포함된것을 확인.
			System.out.println(  c.age   ); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" END ");

	} // main

} // class


// 직렬화가 불가능한 클래스
class Parent{
	public String name;  // X
}

// 직렬화가 가능한 클래스
class Child extends Parent  implements Serializable{   
	 
	private static final long serialVersionUID = -1937494941033300428L;
	
	public int age;    //  O
	
 
	// 부모 Parent의 필드를 직렬화 대상에 포함시키기 위해서 직접 구현..
	// oos.writeObject(c)
	private void writeObject(ObjectOutputStream out) throws IOException {
		
		out.writeUTF(name); // 부모의 직렬화 제외된 필드 + 추가
		out.defaultWriteObject(); // Child 필드 - age
		
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		
		name =   in.readUTF(); //
		in.defaultReadObject();  // Child 필드 - age
 
	}
 
} //



















