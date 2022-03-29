package days28;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author 지민
 * @date 2022. 3. 29. - 오후 3:36:36
 * @subject p911 RandomAccessFile
 * @content 
 * 
 */
public class Ex10 {
public static void main(String[] args) throws IOException {
	String s="i love normal Java";
	String q="javabook";
	
	String name=",\\src\\days28\\random.txt";
	String mode="rw"; //read write 모드 
	try(RandomAccessFile raf=new RandomAccessFile(name,mode)){
		raf.writeBytes(s);
	}catch(Exception e) {
		e.printStackTrace();
	}
	System.out.println("엔터치면 계속 진행 ");
	System.in.read();
	System.in.skip(System.in.available()); 

	try(RandomAccessFile raf=new RandomAccessFile(name,mode)){
		//파일의 위치를 지정해서 그 위치에게 q 문자열 저장(쓰기)
		//파일의 위치 ==파일 포인터(file-pointer)
		raf.seek(7);
		raf.writeBytes(s);
	}catch(Exception e) {
		e.printStackTrace();
	}
	System.out.println("엔터치면 계속 진행 ");
	System.in.read();
	System.in.skip(System.in.available());
	try(RandomAccessFile raf=new RandomAccessFile(name,mode)){
		//파일의 위치를 지정해서 그 위치에게 q 문자열 저장(쓰기)
		//파일의 위치 ==파일 포인터(file-pointer)
		raf.seek(2);
		String line=raf.readLine();
		System.out.println(line);
	}catch(Exception e) {
		e.printStackTrace();
	}
	System.out.println("end");
}

}
