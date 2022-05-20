package days11;

/**
 * @author 지민
 * @date 2022. 3. 3. - 오후 3:50:46
 * @subject 
 * @content 
 * 
 */
public class Ex04_04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] m = new int[3];   
		m[0] = 100;
		m[1] = 85; 
		m[2] = 93;

		// 2개의 정수를 더 저장을 해야 된다.
		// m 배열의 크기(길이)를 2개 더 증가 ( 변경 )
		m = increaseArraySize(m, 5); 
		//  ArrayIndexOutOfBoundsException: 3
		m[3] = 80;
		disp(m);
	}  // main

	public static int [] increaseArraySize(int[] m, int n) {

		int [] temp = new int[ m.length + n ];
		for (int i = 0; i < m.length; i++) {
			temp[i] = m[i];	
		}
		// increaseArraySize.m =temp
		// m = temp; 
		
		return temp;

	}

	private static void disp(int[] m) {

		for (int i = 0; i < m.length; i++) {
			System.out.printf("m[%d]=%d\n", i, m[i]);  //  X
		} 

	}

}//class
