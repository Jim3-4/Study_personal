package days29.sample;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex02 { 
	
	public static void main(String[] args) throws IOException {
		// 2. FileInputStream  실행파일 읽어와서 
		//                         FileOutputStream 다른경로에 복사
		String pathName1 ="C:\\Program Files (x86)\\EditPlus 3\\editplus.exe";
		String pathName2 ="D:\\editplus.exe";
		long start = System.nanoTime();
		
		// fileCopy(pathName1,pathName2); //  11017866610 ns
		
		// [ 버퍼 기능 + InputStream/OutputStream ]
		// BufferedInputStream   BufferedOutputStream  바이트스트림
		fileCopy2(pathName1,pathName2); //      133588178 ns

		long end = System.nanoTime();
		System.out.println("> 복사  완료 : " + (end-start)+" ns");
	}

	private static final int BUFFER_SIZE = 512;
	
	private static void fileCopy2(String pathName1, String pathName2) 
			throws IOException {
		byte [] buffer = new byte[BUFFER_SIZE];
		File file = new File(pathName1);
		System.out.printf("%s\t%d bytes \n", file.getName(), file.length());
		
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(pathName2);
		// 필터 스트림
		BufferedInputStream bis = 
				new BufferedInputStream(fis, BUFFER_SIZE);
		BufferedOutputStream bos =
				new BufferedOutputStream(fos, BUFFER_SIZE);
		
		// 네트워크 
		 int count;
		 while(  (count = bis.read(buffer) )  != -1 ){
			 bos.write(buffer, 0, count);
		 }
		
		bis.close(); // 
		bos.close(); //
		fis.close();
		fos.close();
		System.out.println(" FileCopy END ");
	}

	private static void fileCopy(String pathName1, String pathName2) throws IOException {
		 File file = new File(pathName1);
		 System.out.printf("%s\t%d bytes \n", file.getName(), file.length());
		 //
		 FileInputStream fis = new FileInputStream(file);
		 FileOutputStream fos = new FileOutputStream(pathName2);
		 
		 int data;
		 while(  (data = fis.read() )  != -1 ){
			 fos.write(data);
		 }
		 
		 fis.close();
		 fos.close();
		 System.out.println(" FileCopy END ");
	}

}
