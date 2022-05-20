package days20;

import java.util.Arrays;

/**
 * @author kenik
 * @date 2022. 3. 17. - 오전 11:52:26
 * @subject 
 * @content 
 */
public class Ex04 {

	public static void main(String[] args) throws CloneNotSupportedException {
		// 배열 복제  p 458
		/*
		int [] arr = { 1,2,3,4,5 };
		int [] arrClone =  arr.clone();
		arrClone[0] = 100;
		System.out.println(  Arrays.toString(arr) );   
		System.out.println(  Arrays.toString(arrClone) );   
		*/
		
		//  p 459 얕은 복사(복제)와 깊은 복사(복제)
		// 12:05 수업 시작~

		T t1 = new T();
		// [0]a [0x200]m                         ->                   [0x100]t1
		//         0x200 [][][][][][][][][][]
		
		t1.m = new int[10];
		
		//T t2 = t1.clone();
		// 0x300 [0]a [0x400]m                         ->                   [0x300]t2
    //      0x400 [][][][][][][][][][]
		
	} // main

} // class

class T implements Cloneable{
	int a;
	int [] m =  null;  // 참조타입

	@Override
	protected T clone() throws CloneNotSupportedException { 
		return (T)super.clone();
	}
	
}

// Car myCar = new Car();
// myCar.engine = new Engine();


// myCar 복제
// Car c1 = myCar.clone();

class Car{
	int door;
	String color;
	Engine engine;
}

class Engine{
	
}




