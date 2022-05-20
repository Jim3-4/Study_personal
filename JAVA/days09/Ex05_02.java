package day09;

/**
 * @author 지민
 * @date 2022. 2. 25. - 오후 4:45:47
 * @subject 
 * @content 
 * 
 */
public class Ex05_02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
// [1.,1] 2 3 5 8 13 21 34 55 89 ........... <=150  항의 수와 합 
			int first=1;
			int second=1;
			int sum=first+second, count=1; //이미 한번더함  
			int result;
			while(sum<=150) {
				result=first+second;
				System.out.printf("%d  ", result);
				sum+=result;
				
				first=second;
				second=result;
				count++;
			}
			System.out.println();
			System.out.printf("%d 번 째 , 합은 %d",count,sum);
			
	}

}
