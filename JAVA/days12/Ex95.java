package days12;

import java.util.Arrays;

/**
 * @author 지민
 * @date 2022. 3. 4. - 오전 10:21:38
 * @subject 배열의 단점
 * @content  배열의 크기가 자동증가/감소x , 추가 삭제 수정 등등
 * 
 */
public class Ex95 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//배열의 단점 
		//배열의 길이가 자동 감소/ 증가 x
		int [] m= {1,2,3,4,5};
		System.out.println(Arrays.toString(m));
		//새로운 요소를  추가
		int idx=5;
		if(idx==m.length) {
			System.out.println("배열 크기가 부족 ");
			
			//컨트롤키 누르고 함수 누르면, 바로 이동함 
			m=days11.Ex04_04.increaseArraySize(m, idx);
		}
		idx++;
		
		//[1,2,3,4,5,100,0,0,0,0,0]
		//2. m[3] 요소의 값을 제거
		//[1,2,3,5,100,0,0,0,0,0,0]
		// ㄱ. 제거할 위치(3)보다 큰 인덱스의 배열값을 앞으로 1칸씩 이동 
		// ㄴ. 마지막 값(100)은 다시 초기화 
		// ㄷ. idx 1감소 
	
		System.out.println(Arrays.toString(m));
	for(int i=4;i<idx; i++) {
		m[i-1]=m[i];
	}
	m[idx-1]=0;
	idx--;
	
	}//main

}//class
