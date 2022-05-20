package days12;

/**
 * @author 지민
 * @date 2022. 3. 4. - 오후 3:40:21
 * @subject 
 * @content 
 * 
 */
public class Ex11_02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int [] m=new int[8]; int 정수 8개를 저장할 기억공간 m[열]
		 * 
		 * int[][] m=new int[4][2]; m[행][열] m[0][1]~m[3][2]
		 */
		 int [] n=new int[8]; 
		System.out.println(n.length);	
		dispM(n);
		
		int[][][] m=new int[2][3][4];
		System.out.println(m.length);
		
		System.out.println(m[0].length);
		System.out.println(m[1].length);
		System.out.println(m[2].length);
		
		System.out.println(m[0][0].length);
		System.out.println(m[0][1].length);
		System.out.println(m[0][2].length);
		System.out.println(m[0][3].length);
	}
	private static void dispM(int[][][] m) {
		// TODO Auto-generated method stub
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[i].length; j++) {
				for(int k=0; k<m[i][j].length; k++) {
					System.out.printf("m[%d][%d][%d]=%d\t",i,j,k,m[i][j][k]);
				}
			}
		}
	}
	/**
	 * @param m
	 */
	private static void dispM(int[] m) {
		// TODO Auto-generated method stub
		for(int i=0; i<m.length; i++) {
			System.out.printf("m[%d]=%d\t",i,m[i]);
		}
	}

}
