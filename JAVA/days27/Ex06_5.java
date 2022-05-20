package days27;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 지민
 * @date 2022. 3. 28. - 오전 11:49:22
 * @subject 
 * @content 
 * 
 */
public class Ex06_5 {
public static void main(String[] args) {
	String pathname=".\\src\\days27\\Ex01.java";
	String copyPathname="C:\\Users\\kimjm\\OneDrive\\문서\\Exo1.java";
	
	fileCopy_textStream(pathname, copyPathname);
}//main

private static void fileCopy_textStream(String pathname, String copyPathname) {
	// TODO Auto-generated method stub
	long start=System.nanoTime();
	File f1=new File(pathname);
	//File f1=new File(parent, child);
	final int BUFFER_SIZE=1024;
	char[] buffer=new char[BUFFER_SIZE];
	try (FileReader fr=new FileReader(f1);
			FileWriter fw=new FileWriter(copyPathname);
			BufferedReader br=new BufferedReader(fr,BUFFER_SIZE)
			BufferWriter bw=new BufferedWriter(fw,BUFFER_SIZE)
			){
		String line;
		int lineNumber=1;
	
		while((line=br.readLine())!=null) {
			System.out.println(lineNumber++ +":"+line);
		}
		long end=System.nanoTime();
		//처리시간: 3171700ns 파일복사완료 길이는 1419
		System.out.println("처리시간: "+(end-start)+"ns 파일복사완료 길이는 "+f1.length());
	} catch(FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
