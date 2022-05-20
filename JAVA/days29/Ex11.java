package days29;

import java.util.Iterator;

import javax.swing.JOptionPane;

/**
 * @author kenik
 * @date 2022. 3. 30. - 오후 3:52:56
 * @subject 
 * @content 
 */
public class Ex11 {

	public static void main(String[] args) {
		//  p 752 스레드의 [작업을 취소]하는 메서드 
		// 4:04 수업 시작
		// interrupt()  :  스레드 작업 취소 단지 요청만 한다..실제 강제로 종료 X
		//                            interrupted 상태만을 false -> true 로 변경
		//      개발자 코딩으로  interrupted 상태가 변경되었는지만 체크한다면 스레드 종료시킬 수 있다.
		
		// interrupted()
		ThreadWorker t = new ThreadWorker();
		t.start();

		// main 블러킹
		String inputData = JOptionPane.showInputDialog("아무값이나 입력하세요.");
		System.out.println( inputData );
		t.interrupt(); // 작업 취소 요청만 하고  Interrupted상태가 false에서 [true 변경] 
		System.out.println( t.isInterrupted() );  // [true], false
		
		System.out.println(  " main END ");
	}  // main

} // class


class ThreadWorker  extends Thread{
	
	@Override
	public void run() {
		int k = 10;
		// isInterrupted() ; Interrupted상태를 반환하는 메서드  true/false
		while(   k != 0 && !isInterrupted()  ) {
			System.out.println("-");
			// this.sleep(1000);  실행스레드-> 일시정지
			 // 처리되는 시간.... ( 지연시간 )
			 for (long i = 0; i < 25000000000L; i++) { } // 10번
		}
		System.out.println("t 스레드의 작업은 중지 ");
	}
	
}


/*
 * 
 * t1.sleep(5000)초                 5초 일시정지      -> 예외 발생 -> 종료 
 * main 스레드가  t1.interrupt() 메서드 호출
 * 
 * */

/*
 * Ex06_02에서는
 * 쓰레드 처리상태가 어떻게 되는건지 이해가 잘 안됩니다. 
 * main, t1, t2 가 어떤게 실행대기 상태이고 어떤게 실행
 * 상태인지 구분이 잘 안가서 그러는데 
 * 설명 한번만 부탁드리겠습니다.
 */













