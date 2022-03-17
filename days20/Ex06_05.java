package days20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author kenik
 * @date 2022. 3. 17. - 오후 4:15:26
 * @subject 
 * @content 
 */
public class Ex06_05 {

	public static void main(String[] args) {
		// [ 4명 ]
		// 절대 경로
		// String fileName = "C:\\SS16Class5\\JavaClass\\javaPro\\src\\days20\\SS16교육생명단.txt";
		// 상대 경로 - 기준 경로   C:\\SS16Class5\\JavaClass\\javaPro  프로젝트명 ( 기준 )
		// 상대 경로 기호      .   현재 디렉토리
		//                           ..  상위 디렉토리
		//                           .\\..\\..\\    ==  C:\\SS16Class5
		 String fileName=".\\src\\days20\\SS16교육생명단.txt";
	      String []names =new String[22];
	      
	      try (FileReader in = new FileReader(fileName);
	            BufferedReader br=new BufferedReader(in);){
	         String line=null;
	         int lineNumber=1;
	         int idx=0;
	         while ((line=br.readLine())!=null) {
	            //System.out.printf("%d :%s\n",lineNumber++,line);
	            names[idx++]=line;
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      String result="<ol><li>"+String.join("</li><li>", names)+"</li></ol>";
	      //System.out.println(result);
	      //파일 저장
	      fileName=".\\src\\days20\\SS16교육생 명단.htm";
	      try (FileWriter out =new FileWriter(fileName);
	            BufferedWriter bw = new BufferedWriter(out);){
	         bw.write(result);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      System.out.println("END");

		
	}  // main

} // class
