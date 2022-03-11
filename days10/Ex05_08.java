package day10;

/**
 * @author 지민
 * @date 2022. 3. 2. - 오후 4:42:04
 * @subject 
 * @content 
 * 
 */
public class Ex05_08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String rrn=Ex05_02.getRRN();
int vRrn=verificationRrn( rrn);
System.out.println(vRrn);
	}

	/**
	 * @param rrn
	 * @return
	 */
	private static int verificationRrn(String rrn) {
		// TODO Auto-generated method stub
		char[] cRrn=rrn.toCharArray();
		int valSum=0, calSum=0;
		for(int i=1; i<=9; i++) {
			if(i==7)continue;
		 valSum= cRrn[i]*(i+1);
		}
		for(int i=10; i<=14; i++) {
			valSum=cRrn[i]*(i-8);
		}
		calSum= 11-valSum%11;
		return calSum;
	}

}
