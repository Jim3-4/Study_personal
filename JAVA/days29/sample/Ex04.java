package days29.sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex04 {
	public static void main(String[] args) throws IOException {
		Date now = new Date();
		// Fri Oct 16 09:51:26 KST 2015
		// 2015. 10. 16 오전 9:52:12
		// 2015. 10. 16
		/*
		System.out.println(now +" :  " + now.toLocaleString());
		System.err.println(   now.toLocaleString().split("오")[0].trim()   );
		String data = String.format("%tT", now); // 09:55:39
		data = String.format("%tF", now);          // 2015-10-16
		System.out.println(data);  
		*/
		
		// SimpleDateFormat 클래스
		 
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String today = sdf.format(new Date());
		// System.out.println(today);  // 2015-10-16
	 
		 
		String path = "D:\\"+today;
	   String fileName = ".\\src\\days27\\Sist-E.txt";	
	   FileReader reader = new FileReader(fileName);
	   BufferedReader br = new BufferedReader(reader);
	   
	   String name ;
	   while( (name = br.readLine())!= null){
		   File dir = new File(path,name); // D:\\2015.10.16\\장용준
		   dir.mkdirs();		   
	   }
	   br.close();
	   reader.close();
	   System.out.println(" = END = ");
		
		
		/*
		File dir = new File(path);
		
		// [체크] dir.lastModified()  // long ->날짜형 (년월일시분초) 변환
		
		if( !dir.exists() ){
			dir.mkdirs();
		}
		System.out.println(  dir.exists() );  // true
		*/
       
	}

}

