// [로또645]
		// ㄱ.  (int)(Math.random()*45) +1
		// ㄴ.  rnd.nextInt(45)+1  
 
		// Returns a pseudorandom, uniformly distributed
		// int value  between 0 (inclusive) and the specified value (exclusive),
		// 0 <= int   < 45
		// 1 <=   int < 45
		/*
		for (int i = 0; i < 6; i++) {
			System.out.println( rnd.nextInt(45)+1  );
		} 
		*/
		
		// 배열 선언 후 초기화 X
		// *** 참조형은 초기화 하지 않아도 기본값으로 초기화가 되어져 있다.
		// int []의 각 요소의  기본값은  0 이다. 
		int [] lotto = new int[6];
		
		// 로또 번호를 랜덤하게 발생시켜서 lotto 배열에 채워넣는 함수(메서드)
		fillLotto( lotto );

		// 배열이라는 참조형이 매개변수              Call By Reference
		dispLotto( lotto );
	} // main

	public static boolean isDuplicateLotto(int [] lotto, int idx, int temp) {
		boolean flag = false;
		for (int i = 0; i < idx; i++) {
			if( temp == lotto[i]) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	// 1. 기능  2. 매개변수  3. 리턴값(리턴자료형(
	private static void fillLotto(int[] lotto) {
		// 2:00 시작~ 
		// Random 클래스(물건) jdk 1.5
		Random  rnd = new Random();		
        int idx = 0;		
		while(  idx <= 5 ) { 
			int temp = rnd.nextInt(45) + 1;  
			System.out.println(temp);
			if( !isDuplicateLotto(lotto, idx, temp)   ) {
				lotto[idx++] = temp;
			} 
		} // while
		
		// 2:25 로직(알고리즘) 코딩.
		
		/*
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] =  rnd.nextInt(45)+1  ; 
		}
		*/
		
		/*
		lotto[0] =  rnd.nextInt(45)+1  ;  // 7
		
		// 0   중복체크
		lotto[1] = rnd.nextInt(45)+1  ;   // 20
		
		// 0 1  중복체크
		lotto[2] =  rnd.nextInt(45)+1  ;  // 5
		
		// 0 1 2 중복체크
		lotto[3] =  rnd.nextInt(45)+1  ;  // 5
		
		// 0 1 2 3 중복체크
		lotto[4] =  rnd.nextInt(45)+1  ;  // 5
		
		// 0 1 2 3 4 중복체크
		lotto[5] =  rnd.nextInt(45)+1  ;  // 5
		*/
		
	} // fillLotto

	private static void dispLotto(int[] lotto) {
		// 배열명.length == 배열크기  == 6
		for (int i = 0; i < lotto.length; i++) {
		     System.out.printf("[%d]", lotto[i]);
		}
		System.out.println(); // 개행
		
	} // dispLotto

} // class

/*
31
6
9
44
33
29
*/

/*
private static void fillLotto(int[] lotto) {
      
      Random rnd = new Random();
      
      lotto[0] = rnd.nextInt(45)+1; //7
   
      //lotto[1] = rnd.nextInt(45)+1;      
      do {
         lotto[1] = rnd.nextInt(45)+1;
      } while (lotto[0]==lotto[1]);
      
      //lotto[2] = rnd.nextInt(45)+1;
      do {
         lotto[2] = rnd.nextInt(45)+1;
      } while (lotto[0]==lotto[2] || lotto [1]==lotto[2]);
      
      //lotto[3] = rnd.nextInt(45)+1;
      do {
         lotto[3] = rnd.nextInt(45)+1;
      } while (lotto[0]==lotto[3] || lotto [1]==lotto[3]|| lotto [2]==lotto[3]);
      
      //lotto[4] = rnd.nextInt(45)+1;
      do {
         lotto[4] = rnd.nextInt(45)+1;
      } while (lotto[0]==lotto[4] || lotto [1]==lotto[4]|| lotto [2]==lotto[4]|| lotto [3]==lotto[4]);
      
      //lotto[5] = rnd.nextInt(45)+1;
      do {
         lotto[5] = rnd.nextInt(45)+1;
      } while (lotto[0]==lotto[5] || lotto [1]==lotto[5]|| lotto [2]==lotto[5]|| lotto [3]==lotto[5]|| lotto [4]==lotto[5]);
      
   }//fillLotto
 */

/* 로직 X
private static void fillLotto(int[] lotto) {
      Random rnd = new Random();
      for ( int i = 0; i < lotto.length; i++) { // i 0 [1] 2 3 4 5
       
       
         lotto [i] = rnd.nextInt(45)+1;   //lotto[0]=7       lotto[1]=7
         
         // X
         for ( int n = 0; n <= i-1;n++) {
              if(lotto [n] ==  lotto[i])
                  lotto [i] = rnd.nextInt(45)+1;  // 7
         }
}
 */

/*  X
     Random rnd = new Random();
      
      for (int i = 0; i < lotto.length; i++) {  // i  [0] 1 2 3 4 5
        // 중복체크  i -1
         for (int j = 0; j < 0; j++) {         
            do {
               lotto[i] = rnd.nextInt(45)+1;   // lotto[0] = 7
            } while (lotto[i] == lotto[j]);
         }//j for
      }//i for
 */

/*  [O]
private static void fillLotto(int[] lotto) {
    Random rnd = new Random();
    
     lotto[0] = rnd.nextInt(45)+1; //
    
    // 채워넣는 배열의 위치(인덱스, 첨자값)
    for (int i = 1; i < lotto.length; i++) {          // i =  0 [1] 2 3 4 5
       
       lotto[i] = rnd.nextInt(45)+1; //                   *** lotto[0] = 7            lotto[1]= 7

        // 채워져 있는 배열의 요소 == 중복 체크
       for (int j = 0; j < 1; j++) { // lotto[0] ~ [i-1] 까지 [i]와 중복 되었나 체크

          if (lotto[0] == lotto[1]) {
             System.out.printf("lotto[%d] %d\n", j, lotto[j]); // [디버깅] 중복된 수 확인용
             System.out.printf("lotto[%d] %d 중복\n \n", i, lotto[i]); // [j]와 [i] 번째에 중복
             i--; // i 번째 다시 시행 위함
             break; // 중복 있을경우 i - 1 시키고 안쪽 for문 탈출

          } // if

       } // for2
    } // for1
 }// fillLotto

*/

/*
private static void fillLotto(int[] lotto) {
      Random rnd = new Random();

      lotto[0] = rnd.nextInt(45) + 1;   // lotto[0] = 7
      
      for (int i = 1; i < lotto.length; i++) {        // i   1 2 3 4 5
      
         lotto[i] = rnd.nextInt(45) + 1;      // lotto[1] =7
         
         for (int j = 0; j < i; j++) {
             while (lotto[i]==lotto[j]) {
                  lotto[i] = rnd.nextInt(45) + 1;
             }
         }
      }
   }//fillLotto
 * */
