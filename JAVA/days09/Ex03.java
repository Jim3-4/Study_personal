

/**
 * @author 지민
 * @date 2022. 2. 25. - 오전 10:42:22
 * @subject 
 * @content 
 * 
 */
public class Ex03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//재귀함수 호출 (마지막예제)
		//거듭제곰 (power) 
		int result=power(2,3);
		System.out.println(result);
		
		double result1=recursivePower(2,3);
		System.out.println(result1);
	}

	/**
	 * @param i
	 * @param j
	 * @return
	 */
	private static int power(int i, int j) {
		// TODO Auto-generated method stub
		int result=1;
		for(int k=1; k<=j; i++) {
			result*=i;
		}
		return result;
	}
	private static int recursivePower(int i, int j) {
		// TODO Auto-generated method stub
		int result=1;
		result=i*j;
		return result*recursivePower(i,j--);

	}
}
