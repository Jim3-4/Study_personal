package days20;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author kenik
 * @date 2022. 3. 17. - 오전 11:17:21
 * @subject 
 * @content 
 */
public class Ex03 {

	public static void main(String[] args) {
		/*
		 B obj = new B();
		 obj.a;
		 obj.b;
		 */
		
		/*
		A obj = new B();
		//obj.a;
		// obj.b;  X ?        JDK1.5 부터 ~ 공변 반환타입  이해 ( p 457 )
		
	   B x =	(B)obj;
	   x.a;
	   x.b;
	   */
	}

}

// 복제가 가능한 클래스
// 직렬화가 가능한 클래스
class A implements Cloneable, Serializable{
	int a;
	
	public void disp(int a) throws IOException{
		//
		// throw new IOException();
	}
}
class B extends A{
	// int a;
	int b;
	
	/* 접근지정자는 범위가 같거나 클 수 있다. 
	@Override
	protected void disp(int a) {  // throws IOException
		try{
		}catch( IOException e ){
		}
		
	}
	*/
	
	// 오버로딩
	/*
	public void disp(int a, int b) throws IOException{
	
	}
	*/
}



