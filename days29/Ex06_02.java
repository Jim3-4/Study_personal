package days29;

import javax.swing.JOptionPane;

/**
 * @author kenik
 * @date 2022. 3. 30. - 오후 12:39:22
 * @subject 
 * @content 
 */
public class Ex06_02 {

	public static void main(String[] args) {
		// main 스레드 1개 뿐이다. 
		// 블러킹
		
		// 입력용 대화상자를 띄워서 출력하는 스레드를 만들어서 코딩을 수정하자.
		Thread t1 = new InputThead();   // main 스레드 t1 스레드 생성
		t1.setName("input");
		t1.start();   // main 스레드
		
		//
		Thread t2 = new ForThread();// main 스레드 t2 스레드 생성
		t2.setName("for");
		t2.start();// main 스레드 t2 스레드 시작
		
		
		// 장보기, 방청소 
		System.out.println(" END ");

	} // main

} // class

class ForThread  extends Thread{
	@Override
	 public void run() {
		  String tName =  Thread.currentThread().getName();
		  
		  for (int i = 0; i < 20 ; i++) {
			System.out.printf("[%s] - %d\n",  tName, i);  // for - 0
			
			long millis = 1000;   // 1초
			try {
				Thread.sleep(millis);  // 스레드  1초동안 재운다.  
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
		 } // for
		  
	} // run
} // class


// Runnable 인터페이스
// Thread     클래스
class InputThead  extends Thread{
	
	 @Override
	 public void run() {
		  String tName =  Thread.currentThread().getName();
		  //                              BLOCKED 상태        확인/취소 버튼 클릭
		 String inputData = JOptionPane.showInputDialog("[" + tName+ "] 아무값이나 입력하세요.");		
		  System.out.println(  inputData );
	 }
		
} // class








