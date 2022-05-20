package days22;

import java.text.DecimalFormat;

/**
 * @author kenik
 * @date 2022. 3. 21. - 오후 4:41:24
 * @subject p 540 형식화 클래스  :  DecimalFormat 클래스
 * @content                                   숫자를 형식화하는 클래스
 */
public class Ex09 {

	public static void main(String[] args) {
		// 
		int money = 3257600; 
		// 화폐단위 + 3자리마다 콤마
		// "\3,257,600" 출력
		
		// 글꼴때문에.....
		String pattern = "\u00A4 #,###";
		DecimalFormat df = new DecimalFormat(pattern);
		
		String smoney =  df.format(money);
		System.out.println( smoney );
		
		
		
		
		
		
		
		
		
		
		
		
		
		/* 1번
		String  smoney = String.format("\\%,d", money);
		System.out.println( smoney);
		*/
		
		/*
		// 2번
		//              3   2   5   7  6  0   0
		//              006,752,3
		//              3,257,600
		StringBuffer sb = new StringBuffer( money +"" ); 
		sb.reverse(); 
		for (int i = 0; i < sb.length() ; i++) {
			if( i % 4 == 2 )			sb.insert( i+1 , ",");
		}
		String sMoney =  sb.reverse().toString();
	    System.out.println( sMoney  );
	    */

		// 3번
		/*
		String [] sMoney = (money+"").split("");  // [ "3" "2" "3" "2" "0" "0" "0" ]
		String sm="";
		//          끝에서 읽어..
		for(int i = sMoney.length-1 , k = 0; i >= 0; i--, k++) {
			// sm = ",""0""0""0"
			sm = sMoney[i] + sm;
			// 3 숫자를 읽어오면 "," 추가..
			if(k % 3 == 2 ) sm = "," + sm;
		}
		System.out.println(sm);
		*/
	} // main

} // class
