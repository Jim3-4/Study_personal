package days19;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author kenik
 * @date 2022. 3. 16. - 오전 11:32:27
 * @subject 
 * @content 
 */
public class Ex06_02 {
	

	public static void main(String[] args) {
		//
		new MyForm();

		// 윈도우 [X] 닫기 버튼 클릭하면 프로그램 종료
		// 1. 자바 이벤트 처리
		//    ㄱ. 리스너                      이벤트 핸들러  <- 윈도우 리스너(청취자) <- 윈도우이벤트 발생
		//    ㄴ. 어댑터 ***          리스너 사용하니깐 이벤트 핸들러도 오버라이딩  {}
	} // main

} // class

class MyForm extends Frame{
	
	// 버튼
	Button btnExit;
	 
	// 디폴트 생성자
	MyForm(){
		this.setTitle("새 윈도우(창)");
		this.setSize(400, 400);
		// this.addWindowListener( new MyFormWindowListener() );  // 2. 윈도우리스너 객체 생성
		/*
		this.addWindowListener(  new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {  }
			
			@Override
			public void windowIconified(WindowEvent e) {  }
			
			@Override
			public void windowDeiconified(WindowEvent e) { }
			
			@Override
			public void windowDeactivated(WindowEvent e) { }
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println(" 프로그램 종료!!!");
				System.exit(-1);
			}
			
			@Override
			public void windowClosed(WindowEvent e) { }
			
			@Override
			public void windowActivated(WindowEvent e) { }
		}  );
		*/
		                                            // 인터페이스 업캐스팅..
		// this.addWindowListener(  new MyFormWindowAdapter() );
		
		this.addWindowListener(   new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { 
				System.out.println(" 프로그램 종료!!!");
				System.exit(-1);
			}
		}    ); 
		
		
		// btnExit 버튼 초기화(설정)
		this.btnExit = new Button(  "exit button" );
		// this.btnExit.setLabel(label);
		// 버튼을 클릭해도 이벤트 처리 X
		this.btnExit.addActionListener( new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(  " 종료 버튼 클릭됨...");
			}
		} );
		this.add(btnExit);
		
		// 윈도우 배치(layout) 설정 X
		
		this.setVisible(true);
		
	} // constructor
} // class


/*
// 1. 윈도우어댑터 클래스 선언
class MyFormWindowAdapter extends WindowAdapter{
	@Override
	public void windowClosing(WindowEvent e) { 
		System.out.println(" 프로그램 종료!!!");
		System.exit(-1);
	}
}
*/

/*
// 1. 윈도우리스너  클래스 선언
class MyFormWindowListener implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) { }

	@Override
	public void windowClosing(WindowEvent e) { 
		System.out.println(" 프로그램 종료!!!");
		System.exit(-1);
	}

	@Override
	public void windowClosed(WindowEvent e) { }

	@Override
	public void windowIconified(WindowEvent e) { }

	@Override
	public void windowDeiconified(WindowEvent e) { }

	@Override
	public void windowActivated(WindowEvent e) { }

	@Override
	public void windowDeactivated(WindowEvent e) { }
	
}
*/








