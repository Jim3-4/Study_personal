package days17;

/**
 * @author 지민
 * @date 2022. 3. 14. - 오후 12:40:03
 * @subject 
 * @content 
 * 
 */
public class Ex08 {
public static void main(String[] args) {
	//p323 단일상속 . 다중상속X  
	
	//p325 object클래스 -모든 클래스의 조상 
	//p327- 오버라이딩 

	
	//모든 클래스는 java.lang.Object 클래스를 상속받는다.  
	
	//1.사원객체 선언 및 생성
	Employee emp=new Employee("이상호","서울 영등포구 ", "010-1234-5678", "20180-12-12");
	
	//2.사원정보출력
	emp.dispEmpInfo();
	
	
	Regular emp2=new Regular("김재우", "서울영등포구", " 010-2322-4423", "2019-03-05",3000000);
	emp2.dispEmpInfo();
	

}
}
