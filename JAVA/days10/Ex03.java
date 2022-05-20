package day10;

/**
 * @author 지민
 * @date 2022. 3. 2. - 오전 11:01:09
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
		String rrn="830412-123456";
	
		String regex="-";
		String[] rrns=rrn.split(regex);
		/*
*/
		/*
		 * rrns[1]=rrns[1].charAt(0)+"******";
		 * System.out.println(String.join("-",rrns));
		 */

		System.out.println(rrn.substring(0,7));
		System.out.println(rrn.substring(7,14));
	System.out.println(rrn.substring(0,8)+"******");
	
	char[] rrnCharArray=rrn.toCharArray();
	for(int i=8; i<rrnCharArray.length; i++) {
		rrnCharArray[i]='*';
	}
	for(int i=0; i<rrnCharArray.length; i++) {
		System.out.print(rrnCharArray[i]);
	}

}}
