package days27;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author 지민
 * @date 2022. 3. 28. - 오후 2:53:49
 * @subject 
 * @content 
 * 
 */
public class Ex09 {

	   public static void main(String[] args) {
	      String dir = ".\\src";
	      // 모든 자바파일을 검색해서  "Lotto" 문자열을 포하하는 파일만 찾아서 출력.
	      String keyword = "Lotto"; 
	      
	      File searchDir = new File(dir);
	      
	      // 검색하는 메서드 
	      printSearchFiles(  searchDir,  keyword);
	      

	   } // main

	   // 재귀 호출
	   private static void printSearchFiles(File searchDir, String keyword) {
	       // 하위 폴더, 파일 목록
	       File [] files = searchDir.listFiles();       
	       for (int i = 0; i < files.length; i++) {          
	         if( files[i].isDirectory() ) {  // 하위 폴더
	            printSearchFiles(files[i], keyword); 
	         }else {  // 파일
	            // (조건)   ???.java 파일만...
	            String fileName = files[i].getName();  // 파일명  ???.java    ???.txt    ???.properties
	            String extension =   fileName.substring( fileName.lastIndexOf(".") + 1 ) ;   //   java           
	            if( extension.equals("java")  ) {
	                                 try (
	                                       FileReader fr = new FileReader(files[i]);
	                                       BufferedReader br = new BufferedReader(fr);
	                                       ){
	                                    String line ;
	                                    StringBuffer sb = new StringBuffer();
	                                    while(   (line=br.readLine())  != null ) {
	                                       sb.append(line+"\r\n");
	                                    } // while               
	                                    if (   sb.indexOf(keyword) != -1) {
	                                       System.out.println(  files[i] );  // 
	                                    } //                
	                                 } catch (Exception e) {
	                                    e.printStackTrace();
	                                 } // try
	            }// if
	         } // if
	      } // for
	      
	   } // method    
	      
	} // class


