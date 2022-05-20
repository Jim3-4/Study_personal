package days28;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @author kenik
 * @date 2022. 3. 29. - 오전 10:48:28
 * @subject  p 879
 * @content 
 */
public class Ex04 {

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
		
		// p 886 Data[InputStream], Data[OuputStream] 바이트 스트림		
		// 11:07 수업 시작~
		// 데이터를 읽고 쓰는데 byte 단위가 아닌 기본형으로 읽고 쓸 수 있는 장점을 가진 바이트 스트림.
		
		String name = "마상민";
		int kor = 98, eng = 78, mat = 88 ;
		int tot = kor + eng + mat;
		double avg = (double)tot/3;
		boolean gender = true;
		
		// 텍스트파일 읽기/쓰기 -> 바이트스트림 X, 문자 스트림 O
		// FileReader , [ FileWriter ]
		// 위의 한 학생의 성적 정보를 파일로 저장...
		String fileName = ".\\src\\days28\\students.txt";
		
		try ( FileWriter fw = new FileWriter(fileName, true);
				 BufferedWriter bw = new BufferedWriter(fw);  // 보조스트림  8196 byte 버퍼(기본값)
				){
			
			/*
			fw.write(name);
			fw.write(kor);
			fw.write(eng);
			fw.write(mat);
			fw.write(tot);
			fw.write( avg +"");
			fw.write( gender +"");
			*/
			String data = String.format("%s,%d,%d,%d,%d,%f,%b\n", name, kor, eng, mat, tot, avg, gender);
			
			// fw.write(data);
			bw.write(data);
			
			// fw.flush();  //
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} // try
		
		
		System.out.println( " END ");
		
	} // main

} // class













