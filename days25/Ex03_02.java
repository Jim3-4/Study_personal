package days25;

import java.util.Stack;

/**
 * @author 지민
 * @date 2022. 3. 24. - 오전 10:51:39
 * @subject 
 * @content 
 * 
 */
public class Ex03_02 {
public static void main(String[] args) {
	Stack s=new Stack();
	
	s.push("김기태");
	s.push("박재영");
	s.push("정도연");
	s.push("이다원");
	
	String name=(String)s.peek();
	System.out.println(name);
	
	name=(String)s.peek();
	System.out.println(name);
	/*
	 * System.out.println(s.empty()); s.get(s.size()-1); String
	 * name=(String)s.pop();
	 */
	
	int findIdx=s.search("홍길동");
	//수정, 삭제 
	
}//main
}//class
