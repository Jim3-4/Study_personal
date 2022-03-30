package days29;

/**
 * @author kenik
 * @date 2022. 3. 30. - 오후 2:19:27
 * @subject 
 * @content 
 */
public class Ex07 {

	public static void main(String[] args) {
		// p 738 스레드의 우선 순위
		//       ㄴ 멀티 스레드 :   OS 자동 관리(  자원(CPU) 할당 )
		//       ㄴ 우선권(Priority) 설정             - setPriority(1~10)   기본값  5
		//        ㄴ                         10(우선권 제일 높은 값)
		//   OS 관리 - 멀티태스킹(프로세스), 멀티스레드  시분할       -  CPU
		// [X프로세스]  10초
		// A   2초           우선권(10)
		// B   2초
		// C   2초  <--
		
		// [Y프로세스]  10초
				// A  3초
				// B   3초  1초
		//   10(우선권 제일 높은 값)  의미 == 특정 스레드가 더 많은 작업 시간을 갖도록 하는 설정.
		
		PriorityWorker [] t = new PriorityWorker[10];
		
		for (int i = 0; i < t.length; i++) {
			t[i] = new PriorityWorker();
			t[i].setName("t" + (i+1));  // t1, t2  ~ t10
			t[i].setPriority(i+1);        //  1    2       10                         (5)
		}
		for (int i = 0; i < t.length; i++) {
			t[i].start();
		}
		
		System.out.println( " main END ");
		
	} // main

} // class

class PriorityWorker extends Thread{
	
	@Override
	public void run() {
		String tName =  this.getName();  // 스레드 이름
		int tPriority = this.getPriority(); //  1 ~ 10
		
		for (int i = 0; i < 10000; i++) {
			try {
				this.sleep(1);//  다른 스레드 에게 실행 상태를 넘기겠다. 
			} catch (InterruptedException e) { 
				e.printStackTrace();
			} 
		}
		
		System.out.printf("> %s 스레드 : 우선권[%d] 종료\n", tName, tPriority);
	} // run
	
}

/*
> t10 스레드 : 우선권[10] 종료
> t6 스레드 : 우선권[6] 종료
> t8 스레드 : 우선권[8] 종료
> t5 스레드 : 우선권[5] 종료
> t7 스레드 : 우선권[7] 종료
> t9 스레드 : 우선권[9] 종료
> t3 스레드 : 우선권[3] 종료
> t4 스레드 : 우선권[4] 종료
> t2 스레드 : 우선권[2] 종료
> t1 스레드 : 우선권[1] 종료
*/




