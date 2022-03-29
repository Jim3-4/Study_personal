package days28;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

/**
 * @author kenik
 * @date 2022. 3. 29. - 오전 10:48:28
 * @subject  p 879
 * @content    students.dat 파일 읽기
 */
public class Ex04_04 {

	public static void main(String[] args) {
		 
		
		String name ;
		int kor = 98, eng = 78, mat = 88 ;
		int tot = kor + eng + mat;
		double avg = (double)tot/3;
		boolean gender = true;
		 
		String fileName = ".\\src\\days28\\students.dat";
		
		try (
				FileInputStream in = new FileInputStream(fileName);
				DataInputStream dis = new DataInputStream(in);  // 보조스트림
				){
			
			// dis.available()  체크   int
			// EOFException   ==  End  Of  File == 파일의 끝 예외 발생
			// while( dis.available() > 0) { 
			while(true) {
			
				 name =  dis.readUTF();
				 kor = dis.readInt();
				 eng = dis.readInt();
				 mat = dis.readInt();
				 tot = dis.readInt();
				 avg = dis.readDouble();
				 gender = dis.readBoolean();
				 
				 System.out.printf("name=%s,kor=%d,eng=%d,mat=%d,tot=%d,avg=%.2f,gender=%b\n"
						 , name, kor, eng, mat, tot, avg, gender); 
			// System.out.println( dis.available() );
			}
	 
		}  catch(EOFException e) { 
		}
		catch (Exception e) {
			e.printStackTrace();
		} // try
		
		
		System.out.println( " END ");
		
	} // main

} // class













