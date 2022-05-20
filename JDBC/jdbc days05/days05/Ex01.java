package days05;

/**
 * @author k≡n¡k
 * @date 2022. 5. 10. - 오전 7:04:12
 * @subject
 * @content
 */
public class Ex01 {

	public static void main(String[] args) {
		// (1번 문제)
		// 9:40 수업 시작~ 
		// [ 페이징 처리 ]   
		//  [1] 2 3 4 5 6 7 8 9 10 > 
		// 1. 한 페이지에  출력할 게시글 수 : 15 개
		int numberPerPage = 15;
		// 2. 현재 페이지 :  1 번 페이지
		int currentPage = 1;
		// 3. 총 레코드수 : 347
		int totalRecords = 347;
		// 4. 총 페이지수 : 24
		// JAVA :       int totalPages =  (int) Math.ceil(   (double)totalRecords/numberPerPage  );
		int totalPages = 24;
		// 5. 페이징블럭수  1 2 3 4 5 6 7 8 9  10
		int numberOfPageBlock = 10;
		// 6. 페이징블럭의 시작값
		int startOfPageBlock = 1;
		int endOfPageBlock ;
		
		// ****
		for (int i = 1; i <= totalPages; i++) {
			startOfPageBlock = (i -1) /numberOfPageBlock * numberOfPageBlock +1 ;
			endOfPageBlock = startOfPageBlock + numberOfPageBlock -1;
			if(  endOfPageBlock > totalPages ) endOfPageBlock = totalPages;
			
			// System.out.printf("현재 페이지 : %d\t%d ~ %d\n", i, startOfPageBlock , endOfPageBlock);
			System.out.printf("현재 페이지 : %d\t", i );
			
			if( startOfPageBlock != 1 ) System.out.print(" < ");			
			for (int j = startOfPageBlock; j <= endOfPageBlock ; j++) {
				System.out.printf(j==i?"[%d] ":"%d ", j);
			}			
			if( endOfPageBlock != totalPages ) System.out.print(" > ");
			
			System.out.println();
			
		}
		
		// 11:07 수업 시작~
		// 12:01 수업 시작~ "페이징 처리" 추가
		// 14:00  검색된 결과도 - 페이징 처리 추가
		// writer = '김검색' 검색   39개 게시글
		/*
		148	ADIVXWRPFR                      김검색	2022-05-10	134
		147	LXEDMANMIY                      김검색	2022-05-10	104
		146	LKVTMUPIWD                      김검색	2022-05-10	18
		145	DEPCKGAPKA                      김검색	2022-05-10	132
		144	WJCJBOXKLH                      김검색	2022-05-10	99
		143	UUZVCMOOLU                      김검색	2022-05-10	117
		142	QODLBJLTTC                      김검색	2022-05-10	149
		141	JHVCBVOTIG                      김검색	2022-05-10	80
		140	KEGNXJWQNJ                      김검색	2022-05-10	113
		139	VHQREGKEMF                      김검색	2022-05-10	30
		138	VZHDYFTPTD                      김검색	2022-05-10	108
		137	BOSXZFVPLV                      김검색	2022-05-10	50
		136	YBIVRNKDZH                      김검색	2022-05-10	46
		135	LTOWGUZMCZ                      김검색	2022-05-10	37
		                                     [1] 2 3 
		*/

		//  1. 일단 검색결과를 보여주기 전에 페이지번호를 입력받아야 될 거 같습니다
		//  2. searchService에 매개변수로 currentPage를 추가해야될 것 같습니다
		//  3. BoardService.searchService(){} 구현
		//  4. search() 메서드를 바꿔야할것같습니다
		//  5.   14:40 까지  검색 페이지 잘 나오도록 .. 체크 하고 오세요~ 
		//             1조 : OK
		//             2조 : X
		//             3조 : OK
		//             4조 : OK
		// 3:05 수업시작~
		// 6. 검색 출력의         [1] 2 3  페이징블럭 처리
		
		
	} // main

} // class




/*
                          < prev버튼    페이징블럭시작값      페이징블럭종료값                                 next버튼 >
현재 페이지 : 1                        [1] 2 3 4 5 6 7 8 9 10 >
현재 페이지 : 2                       1 [2] 3 4 5 6 7 8 9 10 >
현재 페이지 : 3                       1 2 [3] 4 5 6 7 8 9 10 >
현재 페이지 : 4                       1 2 3 [4] 5 6 7 8 9 10 >
현재 페이지 : 5                       1 2 3 4 [5] 6 7 8 9 10 >
현재 페이지 : 6                       1 2 3 4 5 [6] 7 8 9 10 >
현재 페이지 : 7                       1 2 3 4 5 6 [7] 8 9 10 >
현재 페이지 : 8                       1 2 3 4 5 6 7 [8] 9 10 >
현재 페이지 : 9                       1 2 3 4 5 6 7 8 [9] 10 >
현재 페이지 : 10                      1 2 3 4 5 6 7 8 9 [10] >
현재 페이지 : 11                      <  [11] 12 13 14 15 16 17 18 19 20 >
현재 페이지 : 12                      <  11 [12] 13 14 15 16 17 18 19 20 >
현재 페이지 : 13                      <  11 12 [13] 14 15 16 17 18 19 20 >
현재 페이지 : 14                      <  11 12 13 [14] 15 16 17 18 19 20 >
현재 페이지 : 15                      <  11 12 13 14 [15] 16 17 18 19 20 >
현재 페이지 : 16                      <  11 12 13 14 15 [16] 17 18 19 20 >
현재 페이지 : 17                      <  11 12 13 14 15 16 [17] 18 19 20 >
현재 페이지 : 18                      <  11 12 13 14 15 16 17 [18] 19 20 >
현재 페이지 : 19                      <  11 12 13 14 15 16 17 18 [19] 20 >
현재 페이지 : 20                      <  11 12 13 14 15 16 17 18 19 [20] >
현재 페이지 : 21                       <  [21] 22 23 24
현재 페이지 : 22                      <  21 [22] 23 24
현재 페이지 : 23                      <  21 22 [23] 24
현재 페이지 : 24                      <  21 22 23 [24]
 * */









