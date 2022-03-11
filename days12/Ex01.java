package days12;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 지민
 * @date 2022. 3. 4. - 오전 9:03:19
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
int[] tots= new int[10];
// 1,0~100 임의의 정수를 배열 초기화 
Random rnd=new Random();
for(int i=0; i<tots.length; i++) {	tots[i]=rnd.nextInt(101);

}
System.out.println(Arrays.toString(tots));
	

	int[] ranks=new int[10];
	
	/*
	 * for(int i=0; i<10; i++) { ranks[i]=1; }
	 */
	
	//Arrays 클래스: 배열을 사용하기 쉽도록 기능을 구현해 놓은 클래스 
	Arrays.fill(ranks, 1);

		for(int j=0; j<ranks.length; j++) {
			for(int i=0; i<tots.length; i++) {
				
				//자기 자신은 제외한 나머지 학생과 총점 비교하겠다.
				//	if(j!=i && tots[j]<tots[i]) 이게 정확한 코딩이지만
				//자기 사진과 비교해도 전혀 문제가 되지 않으므로 빼도됨 
				if(tots[j]<tots[i]) ranks[j]++; 
			}
		}
	System.out.println(Arrays.toString(ranks));
	
	for(int j=0; j<ranks.length; j++) {
		for(int i=0; i<tots.length; i++) {
			if(tots[j]<tots[i]) ranks[j]++;
		}
	}
}//main
	}//class
