package day10;

/**
 * @author 지민
 * @date 2022. 3. 2. - 오전 10:03:07
 * @subject 
 * @content 
 * 
 */
public class Ex01_02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int first=1;
		int second=1;
		int next;
		int sum=first+second;
		System.out.print
		(first+"+"+second+"+");
		while((next=first+second)<150) {
	
		System.out.print
		(next+" +");
		sum+=next;
		
		first=second;
		second=next;
		
		}
		System.out.printf("\b="+sum);
	}

}
