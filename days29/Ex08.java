package days29;

/**
 * @author kenik
 * @date 2022. 3. 30. - 오후 2:37:29
 * @subject   p 748 [표13-3]  쓰레드의 상태
 * @content 
 *    NEW - 스레드 생성 + start() X 상태
 *    RUNNABLE - start() 호출 - OS 자원(CPU) 할당받아서 실행 중 1 , [ 실행 대기 상태 ]
 *    TERMINATED - 스레드 작업 종료( 스레드 죽었다 )
 *    TIMED_WAITING - sleep() 메서드에 의해서 그 스레드가 일시 정지된 상태
 *    BLOCKED - 블러킹,  동기화 처리에 의해서 잠김(lock) 상태
 *    WAITING -    Object.wait() 메서드      ->   일시정지      ->Object.notify(), notifyAll() 메서드 
 */
public class Ex08 {

	public static void main(String[] args) {
	     // sleep()  RUNNABLE 상태< -> 일시정지상태 (TIMED_WAITING)-> 자동 시간
		// wait()                                 <-               WAITING
		//  
		StatusWorker t1 = new StatusWorker();
		// 1. t1 스레드 생성했지만   t1.start() 메서드는 호출하지 않은상태
		System.out.println( t1.getState() );  // NEW
		
		t1.start();
		System.out.println( t1.getState() );   // RUNNABLE  실행대기

		
		try {
			Thread.sleep(3000);  // main 스레드  일시정지 상태.된다.        자동 3초 후  실행대기 상태 된다.
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}  // 5초
		
		// t1.run(){} 처리 + 자동으로 스레드는 종료		
		// t1 5초동안 sleep()  일시정지                   // TIMED_WAITING
		System.out.println( t1.getState() );     // TERMINATED
		
		// 아직 t1 sleep(5000)  일시 정지된 상태...
		t1.interrupt();
		
		System.out.println( " END ");
	} //main

} // class

class StatusWorker extends Thread{
	@Override
	public void run() {
		
		System.out.println(" 1.....");
		
		try {
			this.sleep(5000); // t1 스레드가 5초 동안 일시정지
		} catch (InterruptedException e) { 
			// e.printStackTrace();
			System.out.println(">>>>>>> InterruptedException 예외.. 코딩");
		}
		
		System.out.println(" 2.....");
		
	} // run
} // class









