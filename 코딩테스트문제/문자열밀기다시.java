package lv0;

import java.util.Iterator;

public class Main{
	 public static int solution(String A, String B) {
	
		 int result=-1;
		 if(A.equals(B)) result=0;
		 String addstr=" ";
		 for (int i = 0; i < A.length(); i++) {
			 //맨끝문자를 저장할 변수 
			 //substring은 매개변수가 하나면 beginIndex~ 끝 을 나타난다. 
			 //인덱스가 맨 마지막 인덱스를 가르키니, 맨 마지막 글자만 추출한다. 
			 String end=A.substring(A.length()-1);
			 //substring 할 변수 
			 String temp=end+A.substring(0,A.length()-1);
			 //이 두개를 합칠 변수 
			 A=temp;
			 System.out.println(i+", "+A);
			 if(A.equals(B)) {
				 result=i+1;
				 System.out.println("result: "+result);
			 }
		}//for
		return 0;

	    }
	  public static void main(String[] args) {
			String A="hello";
			String B="ohell";
			//hello lohel 2
			System.out.println(solution(A,B));
			
			String C="apple";
			String D="elppa";
			System.out.println(solution(C,D));
			
			String E="hello";
			String F="elloh";
			System.out.println(solution(E,F));
		}
}
