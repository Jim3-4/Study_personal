package days23;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * @author kenik
 * @date 2022. 3. 22. - 오전 10:12:41
 * @subject   // p 543 예제 10-11      
 * @content 
 */
public class Ex02_04 {

	public static void main(String[] args) {
		String smoney = "1,234,567.89";
		// 1. 
		// double money =   Double.parseDouble(   smoney.replaceAll("[\\,]", "") );
		// System.out.println( money );
		
		
		// 2.    \u00A4   [
		double money;
		String pattern = "#,###.##" ;
		DecimalFormat df = new DecimalFormat(pattern); 
		try {
		   Number  num	= df.parse(smoney);
		   money =   num.doubleValue();
		   System.out.println( money );
		} catch (ParseException e) { 
			e.printStackTrace();
		}
		 

	} // main

} // class
