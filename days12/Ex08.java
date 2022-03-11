package days12;

import java.util.Arrays;

/**
 * @author 지민
 * @date 2022. 3. 4. - 오전 11:11:51
 * @subject 
 * @content 
 * 
 */
public class Ex08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] m= {3,5,2,4,1};
		//버블정렬
		int []m1=bubbleSort(m);
		System.out.println(Arrays.toString(m1));
		
		//선택정렬
		m=selectionSort(m);
		System.out.println(Arrays.toString(m));
		
	}

	/**
	 * @param m
	 * @return
	 */
	private static int[] selectionSort(int[] m) {
		// TODO Auto-generated method stub
		for(int i=0; i<m.length-1; i++) {
			for(int j=i+1; j<m.length; j++) {
				if(m[i]>m[j]) {
					int temp=m[i];
					m[i]=m[j];
					m[j]=temp;
				}
			}
		}
		return m;
	}

	/**
	 * @param m
	 * @return
	 */
	private static int[] bubbleSort(int[] m) {
		// TODO Auto-generated method stub

		for(int i=0; i<4; i++) {
			for(int j=0; j<4-i; j++) {
				System.out.println((i+1)+"회전");
				
				//오름차순 정렬
				System.out.printf("%d -%d자리 비교 ",j,j+1);
				if(m[j]>m[j+1]) {//부등호만 바꾸면 내림차순 정렬됨 
					System.out.print("***"); //자리바꿈이 일어났다는 증거 
					int temp=m[j];
					m[j]=m[j+1];
					m[j+1]=temp;
					
				}
			}
		}
		return null;
	}

}
