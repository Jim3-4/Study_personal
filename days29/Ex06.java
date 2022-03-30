package days29;

import javax.swing.JOptionPane;

/**
 * @author kenik
 * @date 2022. 3. 30. - 오후 12:39:22
 * @subject 
 * @content 
 */
public class Ex06 {

	public static void main(String[] args) {
		// main 스레드 1개 뿐이다. 
		// 블러킹
		
		// 입력용 대화상자를 띄워서 출력하는 스레드를 만들어서 코딩을 수정하자.
		String inputData = JOptionPane.showInputDialog("아무값이나 입력하세요.");		
		System.out.println(  inputData );
		
		
		// 장보기, 방청소 
		System.out.println(" END ");

	} // main

} // class
