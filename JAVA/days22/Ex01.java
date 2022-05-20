package days22;

import java.util.Scanner;

/**
 * @author kenik
 * @date 2022. 3. 21. - 오전 7:41:50
 * @subject >22	2022-03-21(월)<
 * @content  2조_프로그램스_문제
 */
public class Ex01 {
	
	public static void main(String[] args) {
		// 10시 45분  풀이 .~ 
		Scanner scanner = new Scanner(System.in);
		//막대기 수 입력 및 유효성 검사
		int n;
		do {
			System.out.print(">막대기 수를 입력하세요");
			n = scanner.nextInt();
		} while (!(1<=n && n<=1000));

		// 막대기 수 유효성검사 regex로 하는 버전
		/*
		String nString; 
		String nRegex = "1000|[1-9][0-9]?[0-9]?";    // {1,3}
		// 1000 | [1-9][][] (1~9)| [1~9][0-9][] (10~99) | [1-9][0-9][0-9] (100~999)
		do {
			System.out.print(">막대기 수를 입력하세요");
			nString = scanner.next(); 
		} while (!nString.matches(nRegex));
		int n = Integer.parseInt(nString);
		 */



		// 막대기 길이 입력 및 유효성 검사
		int[] bars = new int[n];
		Loop1 : while (true) {
			System.out.print(">길이를 입력하세요");
			for (int i = 0; i < bars.length; i++) {
				bars[i] = scanner.nextInt();
			}
			for (int i = 0; i < bars.length; i++) {
				if (!(1<=bars[i] && bars[i]<=1000)) continue Loop1;
			}
			break Loop1;
		} 
		// while문안에서 for문을 두개나 돌리는게 문제로 보임
		// 유효성 검사가 제대로 되는 것은 맞는 것으로 보임


		// cut operation
		int min;           // 길이가 가장 짧은 막대기 
		int minIdx;       //                        "            인덱스값(위치)
		int count;
		
		while (n > 0) {  // 막대기 갯수 > 0           6/4/2/1 > 0
			minIdx = 0;
			count = 0;
			System.out.println(n);  // 6
			
			// 가장 작은 막대기의 인덱스 (위치)
			for (int i = 0; i < n; i++) {  // 모든 막대기 들 반복
				if (bars[minIdx] > bars[i]) {
					minIdx = i;
				}
			} 
			min = bars[minIdx];	
			// 
			
			// 컷 오프레이션            4
			for (int i = 0; i < n; i++) {
				bars[i] = bars[i] - min;
				if(bars[i] != 0) count++;
			}
			
			// 0 제외하고 새로운 배열 생성 - > bars 참조
			int[] temp = new int[count];
			int idx = 0;
			for (int i = 0; i < n; i++) {
				if(bars[i] != 0) temp[idx++] = bars[i];
			}
			bars = temp;
			n = bars.length;
		}
		scanner.close();

	} // main



} // class



/*
문제3) 막대기 자르기  - 취업문제 

각각 0이상의 정수를 길이로 하는 N개의 막대기가 있다.

 이 막대기들 중 가장 짧은 막대기의 길이로 모든 막대기를 자르는 것을 [cut operation]이라고 하자.

예를 들어 6개의 막대기가 있고 그 길이가 다음과 같다면 

5 4 4 2 2 8 

이 경우 [Cut Operation]을 한번 수행하면 다음과 같다. 

3 2 2 6

(가장 짧은 길이인 2로 6개의 막대기를 잘라내고 길이가 0이 되버린 2개의 막대기는 버려진다.) 

N개의 막대기와 그 각각의 길이가 주어졌을 때 [Cut Operation]을 모든 막대기가 버려질 때(길이가 0이 될때)까지 반복하고  수행 시 마다 남은 막대기의 수를 출력하는 프로그램을 작성하라. 

입력 
첫줄에 막대기의 수 N을, 다음 줄에 각각의 막대기의 길이를 공백으로 구분해서 입력한다.

출력 
매 줄마다 [Cut Operation]이 수행 되 때 마다 남은 막대기의 수를 출력 

제한 
1 <= N <= 1000
1 <= 막대기의 길이 <= 1000

입력 예제 #1
6
5 4 4 2 2 8

출력 예제 #1
6
4
2
1

입력 예제 #2
8
1 2 3 4 3 3 2 1

출력 예제 #2
8
6
4
1 
 */ 	






/*
 *                      [C 9 유용한 클래스 - 자주]    
 *                      C 10 날짜/시간
 *                      C 11 컬렉션 프레임워크
 *                      C 12 지네릭스,열거형, 어노테이션 @override
 *                      C 15 입출력(I/O)
 *                      C 13 스레드
 *                      C 16 네트워크
 */