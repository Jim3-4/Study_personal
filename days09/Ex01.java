package day09;

/**
 * @author 지민
 * @date 2022. 2. 25. - 오전 9:09:20
 * @subject 
 * @content 
 * 
 */
public class Ex01 {
public static void main(String[] args) {
	/*
	 * int sum=10 , n=10; for(int i=0; i<=n; i++) { sum+=i;
	 * 
	 * } System.out.println("\b"+sum);
	 */
	
	int a=3,b=8;
	//두 정수 a,b 사이의 합을 구해서 반환하는 sum()메서드를 선언, 호출
	int result=recursiveSum(n);
	
	 }//main
	
public static int calSum(int n) {
	int result=0 ;
	 for(int i=0; i<=n; i++) {
		 result+=i;
		 
	 }
return result;
	 }//함수 calSum(int n)

public static int calSum(int a, int b) {
	int result=0 ;
	int min=a<b ? a:b;
	int max = a>b? a:b;
	 for(int i=min; i<=max; i++) {
		 result+=i;
		 
	 }
return result;
}// int calSum(int a, int b) 

/*
 * private static int recursiveSum(int n) { jf (n==1) { return n;} else { return
 * n+recursiveSum(n-1);} }
 */
}//class


