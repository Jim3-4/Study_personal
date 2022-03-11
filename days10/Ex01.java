package day10;

/**
 * @author 지민
 * @date 2022. 3. 2. - 오전 9:32:47
 * @subject 
 * @content 
 * 
 */
public class Ex01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [1.,1] 2 3 5 8 13 21 34 55 89 ........... <=150  항의 수와 합 
		/*
		 * int first=1; int second=1; int sum=first+second, count=1; //이미 한번더함 int
		 * result; while(sum<=150) { result=first+second; System.out.printf("%d  ",
		 * result); sum+=result; if(sum>=150) { sum-=result; break; }
		 * 
		 * first=second; second=result; count++; } System.out.println();
		 * System.out.printf("%d 번 째 , 합은 %d",count,sum);
		 
		 */
		
		int first=1, second=1;
		int sum=0;
		int next;
		
		int[] m=new int[20];
		m[0]=first; 
		m[1]=second;
		sum=m[0]+m[1];
		System.out.print(m[0]+"  "+m[1]+" "); 
		for( int i=2; i< 20; i++) {
			m[i]=m[i-2]+m[i-1];
	
			if(m[i]>150) break;
			System.out.print(m[i]+ " ");
			sum+=m[i];
		}
	}

}
