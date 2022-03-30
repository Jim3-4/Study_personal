package days29;

import java.util.Iterator;

import javax.swing.JOptionPane;

/**
 * @author kenik
 * @date 2022. 3. 30. - 오후 3:52:56
 * @subject 
 * @content 
 */
public class Ex11_02 {

	public static void main(String[] args) {
	 
		ThreadWorker02 t = new ThreadWorker02();
		t.start(); 
		
		String inputData = JOptionPane.showInputDialog("아무값이나 입력하세요.");
		System.out.println( inputData );
		t.interrupt();   // interrupted 상태 false ->  true
		System.out.println( t.isInterrupted() );   // true
		
		System.out.println(  " main END ");
	}  // main

} // class


class ThreadWorker02  extends Thread{
	
	@Override
	public void run() {
		int k = 10;
		// isInterrupted() ; Interrupted상태를 반환하는 메서드  true/false
		while(   k != 0 && !isInterrupted()  ) {  // !false true
			System.out.println("- " +  isInterrupted());
			
			try {
				this.sleep(1000);  // RUNNABLE 상태 -> 일시정지( 1초 동안 )
			} catch (InterruptedException e) { 
				//e.printStackTrace();
				// 자동으로  interrupted 상태 = false 초기화
				this.interrupt();  // false -> true 변경  ( 추가 )
			}
			
		} // while
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













