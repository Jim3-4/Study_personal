package days29;

/**
 * @author kenik
 * @date 2022. 3. 30. - 오후 3:28:56
 * @subject       
 * @content 
 */
public class Ex10 {

	public static void main(String[] args) {
		// 멀티 스레드 [ 문제점만 파악 ]                해결 나중에 ( 동기화 처리 x)
		// 인쇄기 [공유자원]  1대 
		PrintMachine machine = new PrintMachine();  
		
		PrintWorker t1 = new PrintWorker("박예린", machine);
		PrintWorker t2 = new PrintWorker("백경환", machine);
		PrintWorker t3 = new PrintWorker("안시은", machine);
		PrintWorker t4 = new PrintWorker("함세강", machine);
		PrintWorker t5= new PrintWorker("유환재", machine);
		
		t1.start();   // [***박예린***]   동기화 처리
		t2.start();   // [***백경환***]
		t3.start();
		t4.start();
		t5.start();

	} // main

} // class


// 인쇄하는 일꾼(스레드)
class PrintWorker extends Thread{
	
	String content;  // 인쇄할 내용물	
	PrintMachine machine; // 인쇄기
	
	// 생성자 의존성주입( DI )
	public PrintWorker(String content, PrintMachine machine) {
		super();
		this.content = content;
		this.machine = machine;
	}
	
	@Override
	public void run() {
		this.machine.printContent(content);  // 잠금처리( lock)
	} 
	
}// class

class PrintMachine{
	
	public void printContent( String content) {   // "홍길동"
		// [***홍길동***]  인쇄
	
		try {
			System.out.print("[");
			Thread.sleep(500);
			System.out.print("***");
			Thread.sleep(500);
			for (int i = 0; i < content.length(); i++) {
				System.out.print(content.charAt(i));
				Thread.sleep(200);
			}
			System.out.print("***");
			Thread.sleep(500);
			System.out.print("]");
			System.out.println();  // 개행
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}
		
	} // 
	
}










