package days17;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author 지민
 * @date 2022. 3. 14. - 오전 11:29:40
 * @subject 
 * @content 
 * 
 */
//																top-window (윈도우 ,창) 
public class MyApplication extends Frame implements WindowListener{
//필드x
//메소드x 
	
	//디폴트 생성자 
	public MyApplication() {
		System.out.println("MyApplication 디폴트생성자호출됨 ");
		this.setTitle("새 윈도우창()");
		this.setSize(400,400);
		//this.addWindowListener(new MyAppWindowListener());
		//this.addWindowListener(());
		this.setVisible(true);
	}
	
	
}
//리스너(청취자)선언 =윈도우 관련 이벤트를 처리하는 리스너 선언 
class MyAppWindowListener implements WindowListener {

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("프로그램종료");
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}