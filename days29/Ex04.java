package days29;

/**
 * @author kenik
 * @date 2022. 3. 30. - 오전 11:33:51
 * @subject 
 * @content 
 */
public class Ex04 {

	public static void main(String[] args) {
		
		// main 스레드  (1개 기본)   == 일꾼
		Thread t =  Thread.currentThread();
		String tName =  t.getName();
		System.out.println(  tName  );  // 스레드 이름 :  main
		
		Runnable target = new ShoppingWorker();
		Thread 장보기일꾼 = new Thread(target);
		장보기일꾼.setName("shopping");
		장보기일꾼.start();  //  run() 메서드 호출                  OS 관리
		
		// ㄱ. 방청소   main 스레드 
		/*
		for (int i = 1; i <= 100 ; i++) {
			System.out.printf("> %s - 방청소 : %d%%\n", tName, i);
		} // for
		*/
		Thread 방청소일꾼 = new CleaningWorker("cleaning");
		// 방청소일꾼.setName("cleaning");
		방청소일꾼.start(); 
		
		
		
		// ㄴ. 마트에 쇼핑( 장보기 )
		/*
		for (int i = 1; i <= 100 ; i++) {
			System.out.printf("> %s - 장보기 : %d%%\n", tName, i);
		} // for
		*/
		
		
		// 독립적으로 스레드(일꾼)을 만들어서 장보기 시키자.

		// 12:06 수업 시작
		System.out.println( " END ");
	} // main               실행중인  프로그램 종료 == 프로세스 종료

} // class

// 방청소(일꾼 == 스레드 )
class CleaningWorker extends Thread{
	
	public CleaningWorker(String name) {
		 super(name);
	}

	@Override
	public void run() { 
		Thread t =  Thread.currentThread();
		String tName =  t.getName();
		for (int i = 1; i <= 100 ; i++) {
			System.out.printf("> %s - 방청소 : %d%%\n", tName, i);
		} // for
	} // run
} // class


// 장보기(일꾼 == 스레드 )
class ShoppingWorker implements Runnable{

	@Override
	public void run() { 
		// run() 메서드 :    이 스레드가 독립적으로 해야될 일(기능)을 구현 
		Thread t =  Thread.currentThread();
		String tName =  t.getName();
		for (int i = 1; i <= 100 ; i++) {
			System.out.printf("> %s - 장보기 : %d%%\n", tName, i);
		} // for
	} // run
	
} // 











