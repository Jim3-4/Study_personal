package days29.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex01 {

	public static void main(String[] args) throws IOException {
		// 1. FileInputStream 실행파일 읽어와서 모니터 출력
		String pathName ="C:\\Program Files (x86)\\EditPlus 3\\editplus.exe";
		File file = new File(pathName);
		System.out.printf("%s\t%d bytes \n",
				file.getName(), file.length());
		// 바이트 스트림 : 1바이트    바이트/바이트배열/정수
		FileInputStream fis = new FileInputStream(file);
		/*
		int data ;
		while((data = fis.read() ) != -1 ){
			System.out.println(data);
		}
		*/
		
		int count ;
		byte [] datas = new byte[10]; 
		while( (count=fis.read(datas))!= -1 ){
			for (int i = 0; i < count; i++) {
				System.out.println(datas[i]);
			}
		}
		
		fis.close(); // 
		System.out.println(" = END = ");
		

	}

}
