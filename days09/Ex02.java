		// 윤년 - 그레고리오력( 치윤법 )  1)+2)+3)  수식
		// 팩토리얼( factorial )
		
		// 팩토리얼( factorial )  == n계승    
		// 정의 ) 1에서 양의 정수의 곱
		// n! = n*(n-1)*n(-2)*.. *1
		// 예) 5! = 5*4*3*2*1
		//   0! == 1 ( 약속 )
		
		// 계승은 순열과 조합의 공식 자주 사용 
		
		int n = 5;
		
		// [문제]5팩토리얼 값을 구해서 출력하는 코딩을 하세요.  
		// 1+2+3+4+5=15
		/*
		int result = 1; 
		for (int i = 1; i <=n; i++) {
			result *= i;
		}
		System.out.println(result);
		*/
		
		int result = factorial(n);
		System.out.println(result);
		
		result = recursiveFactorial( -11 );  // 재귀 호출 메서드
		if (  result  == -1  ) {
			System.out.println("입력이 잘못되었습니다.");
		} else {
			System.out.println(result);
		}
		

	} // main

	// 3! = 3 * 2 * 1
	// 3! = 3 * 2 * 1 *  1
	
	// 5! =5 * 4 * 3 * 2 * 1  == 120
	// (질문)강사님~ 0이 들어가면 1이 출력되도록 메서드를 수정해야되는거아닌가요??
	// 팩토리얼 정의 ?  1 ~ 양의 정수의 곱	
	// ㄱ. 음의 정수의 팩토리얼 = 입력이 잘못되었습니다.
	// ㄴ 0!                 1
	// (질문) 선생님 혹시 n==1일때가 왜 꼭 필요한가요?
	// (질문) 맨처음 팩토리얼 함수은 for문을돌려서 사용햇는데
	//           두번째 리커시브 팩토리얼  메서드 는 if문 하나만
	//           사용해도 반복이되는건가요?
	//           두개의 차이점을 잘 모르겠습니다...
	
	// ㄱ. 재귀 함수 정의  ? 함수 안에서 자기자신을 호출하는 것을 "재귀 호출" 그런함수를 재귀 함수(메서드)
	public static void disp() {
		System.out.println("disp() 함수 호출됨.");
		disp();
	}
	// ㄴ. 처리 과정 이해 X
	 
	// 재귀 함수(메서드)
	private static int recursiveFactorial(int n) {
		
//		if( n == 1 )  return n;
//		else            return n  * recursiveFactorial(n-1);
		
		if( n > 1 )  return n*recursiveFactorial(n-1);
		else if( n == 1 ) return n;
		else if( n == 0) return 1;
		else                   return -1;
		
		
		 /*  5
		  if(n==1) return n;
	      else if (n==0) return 1;
	      else if (n<0) {
	         System.out.println("입력이 잘못되었습니다.");
	         return 1;    // 고민
	      }
	      else return n*recursiveFactorial(n-1);
	      */
		
	}

	private static int factorial(int n) {
		int result = 1; 
		for (int i = 1; i <=n; i++) {
			result *= i;
		}
	    return result;
	}
