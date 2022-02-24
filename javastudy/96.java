package day08;

/**
 * @author 지민
 * @date 2022. 2. 24. - 오후 3:30:39
 * @subject 
 * @content 
 * 
 */
public class Ex05 {
	int[] m= {10,20};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] m= {10,20};
		System.out.printf("x=%d , y=d\n", m[0], m[1]);
		/*
		 * { int temp=x; x=y; y=temp; }
		 */
		
		swap(m); //call  by reference 
		System.out.printf("x=%d , y=d\n", m[0], m[1]);
	}//main

	private static void swap(int[] m) {
		int temp=m[0];
		m[0]=m[1];
		m[1]=temp;
		
	}

	/*
	 * public static void swap(int[] m, int[] m1) { int temp= x=y; x=temp; }
	 */
	

}
