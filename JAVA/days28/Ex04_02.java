package days28;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

/**
 * @author kenik
 * @date 2022. 3. 29. - 오전 10:48:28
 * @subject  p 879
 * @content 
 */
public class Ex04_02 {

	public static void main(String[] args) {
		// 1. 바이트 스트림  + 파일 읽고 쓰고
		// 2. 실행파일, 이미지, 동영상 파일  + 네트워크                       + 텍스트파일		
		//  File[InputStream]
		//  File[OutputStream]

		// p 883 
		// BufferedInputStream
		// BufferedOutputStream 
		// 1.   바이트스트림의 입출력 효율을 높이기 위해서 사용하는  보조스트림
		// 2. 한바이트 입출력하는 것보다   버퍼( buffer )를 사용해서 여러 바이트를 입출력하는 것이 .. 효율적이다. 
		
		// p 886 Data[InputStream], Data[OuputStream] 바이트  보조 스트림		
		// 11:07 수업 시작~
		// 데이터를 읽고 쓰는데 byte 단위가 아닌 [ 기본형 ]으로 읽고 쓸 수 있는 장점을 가진 바이트 스트림.
		
		String name = "마상민";
		int kor = 88, eng = 98, mat = 68 ;
		int tot = kor + eng + mat;
		double avg = (double)tot/3;
		boolean gender = false;
		
		// 텍스트파일 읽기/쓰기 -> 바이트스트림 X, 문자 스트림 O
		// FileReader , [ FileWriter ]
		// 위의 한 학생의 성적 정보를 파일로 저장...
		String fileName = ".\\src\\days28\\students.dat";
		
		try ( 
				 FileOutputStream out = new FileOutputStream(fileName, true);
				DataOutputStream dos = new  DataOutputStream(out)){
		
			 
			dos.writeUTF(name);  // String
			dos.writeInt(kor);   // int 
			dos.writeInt(eng);   // int 
			dos.writeInt(mat);   // int 
			dos.writeInt(tot);   // int
			dos.writeDouble(avg);// double
			dos.writeBoolean(gender);
			
			dos.flush(); 
			 
		} catch (Exception e) {
			e.printStackTrace();
		} // try
		
		
		System.out.println( " END ");
		
	} // main

} // class













