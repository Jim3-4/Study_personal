package days29.sample;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex03 {

	public static void main(String[] args) 
			                                                throws IOException {
		// FileReader / FileWriter 파일 복사
		String fileName1 = ".\\src\\days26\\Ex09.java";
		String fileName2 = ".\\src\\days26\\Ex09 - 복사본.java";
		long start = System.nanoTime();
		
	    // fileCopy(fileName1, fileName2);  //  19912584 ns 문자단위 처리
		fileCopy2(fileName1, fileName2);     //  19226883 ns 문자단위 처리
		                                                     //  10567425 ns 라인단위 처리
															 //  14248336 ns 512버퍼사용
		
		long end = System.nanoTime();
		System.out.println("> 복사  완료 : " + (end-start)+" ns");
	}

	private static final int BUFFER_SIZE = 1024;
	
	private static void fileCopy2(String fileName1, String fileName2) throws IOException {
		// BufferedReader , BufferedWriter + 버퍼기능
		// 라인 단위 처리 
		FileReader     reader = new FileReader(fileName1);
		FileWriter writer = new FileWriter(fileName2);
		
		// 2차스트림( 필터스트림)
		//BufferedReader br = new BufferedReader(reader);
		//BufferedWriter   bw = new BufferedWriter(writer);
		
		// 버퍼
		char [] buffer = new char[BUFFER_SIZE];
		
		BufferedReader br = new BufferedReader(reader, BUFFER_SIZE);  // 9186 byte
		BufferedWriter   bw = new BufferedWriter(writer, BUFFER_SIZE);
		
		/*  19226883 ns 문자단위 처리
		int n , count=0;
		while (  ( n=  br.read() ) != -1   ){ 
			// 모니터 출력
			bw.write(n);
			count++;
		}
		*/
		/* 10567425 ns 라인단위 처리
		String line ;
		int count=0;
		while (  ( line=  br.readLine() ) != null   ){ 
			// 모니터 출력
			bw.write(line);
			count++;
		}
		*/ 
		
		// 14248336 ns 512버퍼사용
		 
		int count;
		 while(  (count = br.read(buffer) )  != -1 ){  // 234 byte
			 bw.write(buffer, 0, count);
		 }
		
		br.close();
		bw.close();
		reader.close();
		writer.close();  // flush() 
		
		System.out.println("\n = END => " + count);
	}

	private static void fileCopy(String fileName1, String fileName2)
			   throws IOException {
		FileReader     reader = new FileReader(fileName1);
		FileWriter writer = new FileWriter(fileName2);
		
		int n , count=0;
		while (  ( n=  reader.read() ) != -1   ){ 
			// 모니터 출력
			writer.write(n);
			count++;
		}
		reader.close();
		writer.close();  // flush() 
		
		System.out.println("\n = END => " + count);
		 
		
		
		
	}

}
