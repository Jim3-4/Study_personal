package days15;

/**
 * @author 지민
 * @date 2022. 3. 10. - 오전 10:10:57
 * @subject 
 * @content 
 * 
 */
 //Package 접근지정자를 선택하니까, 앞에 public이 안붙는다 = default 
class Person {
	String name;
	int age; 
	
	//기능 =멤버함수=메서드 
	void walk() {
		System.out.println("걷고 잇다. ");
	}
	void run() {
		System.out.printf("%s이 뛴다.\n",name);
	}
}
