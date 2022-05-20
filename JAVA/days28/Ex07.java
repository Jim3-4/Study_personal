package days28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author kenik
 * @date 2022. 3. 29. - 오후 12:45:42
 * @subject  p 898 문자 기반 스트림 
 * @content  StringReader StringWritter 
 */
public class Ex07 {

	public static void main(String[] args) throws IOException {
		//p901 [piped] Reader/Writer 
		//프로세스간 전송
		//p903 String reader/String Wirter 메모리스트림 
		//CharArrayReader/CharArrayWriter 메모리승트림 byteARrayinputStream
		
String source="package days28;\r\n"
		+ "\r\n"
		+ "import java.io.File;\r\n"
		+ "import java.io.FileInputStream;\r\n"
		+ "import java.io.FileOutputStream;\r\n"
		+ "import java.io.PrintStream;\r\n"
		+ "\r\n"
		+ "// 510차이\r\n"
		+ "/**\r\n"
		+ " * @author kenik\r\n"
		+ " * @date 2022. 3. 29. - 오전 7:27:02\r\n"
		+ " * @subject  \r\n"
		+ " * @content \r\n"
		+ " */\r\n"
		+ "public class Ex01 {\r\n"
		+ "\r\n"
		+ "	public static void main(String[] args) {\r\n"
		+ "		// >28	2022-03-29(화)<\r\n"
		+ "		// p 915~930  File 클래스 수업 완료. \r\n"
		+ "		// p 931~\r\n"
		+ "		// p 868~\r\n"
		+ "		\r\n"
		+ "		// 실행 파일 ( exe ) 복사 		\r\n"
		+ "		String pathname = \"C:\\\\Program Files (x86)\\\\EditPlus 3\\\\editplus.exe\";\r\n"
		+ "		String copyPathname = \"C:\\\\Users\\\\redke\\\\OneDrive\\\\문서\\\\editplus.exe\";\r\n"
		+ "		\r\n"
		+ "		// > 처리 시간 : 7374200 ns  -  파일(2941 bytes) 복사 완료!!\r\n"
		+ "		fileCopy_byteStream(pathname, copyPathname);\r\n"
		+ "		\r\n"
		+ "\r\n"
		+ "	} // main\r\n"
		+ "\r\n"
		+ "	private static void fileCopy_byteStream(String pathname, String copyPathname) {\r\n"
		+ "       long start =  System.nanoTime();		\r\n"
		+ "		File f1 = new File(pathname);  \r\n"
		+ "		PrintStream ps = System.out;  // 화면에 출력하는 스트림 객체  , 바이트스트림\r\n"
		+ "		try(\r\n"
		+ "				FileInputStream fis = new FileInputStream(f1);\r\n"
		+ "				FileOutputStream fos = new FileOutputStream(copyPathname);\r\n"
		+ "				){\r\n"
		+ "			int b ;\r\n"
		+ "			 while( ( b = fis.read() ) != -1) {\r\n"
		+ "				 //ps.write(b);\r\n"
		+ "				 //ps.println(b);\r\n"
		+ "				 fos.write(b);  // 파일로 복사\r\n"
		+ "			 }\r\n"
		+ "			\r\n"
		+ "		}catch (Exception e) {\r\n"
		+ "			e.printStackTrace();\r\n"
		+ "		} // try\r\n"
		+ "		\r\n"
		+ "		long end =  System.nanoTime();\r\n"
		+ "		\r\n"
		+ "		// > 처리 시간 : 48901880400 ns  -  파일(2385496 bytes) 복사 완료!!\r\n"
		+ "		System.out.println( \"> 처리 시간 : \" + (end-start) +\" ns  -  파일(\"+ f1.length() +\" bytes) 복사 완료!!\");\r\n"
		+ "	\r\n"
		+ "		// 네트워크 - 파일전송   바이트->바이트\r\n"
		+ "	}\r\n"
		+ "\r\n"
		+ "} // class\r\n"
		+ "\r\n"
		+ "\r\n"
		+ "/*\r\n"
		+ " * 1. 스트림(stream) ?\r\n"
		+ " * 2. 스트림 종류\r\n"
		+ " *    ㄱ. 방향  : 입력(Input), 출력(Output) \r\n"
		+ " *    ㄴ. 대상  **** ( 암기 )\r\n"
		+ " *         1)\r\n"
		+ " *         2)\r\n"
		+ " *  3. 스트림 == 빨대( 연결통로 )\r\n"
		+ " *  4. 파일 ->       파일 복사               ->   파일\r\n"
		+ " *                                                       ->   화면(콘솔) 출력\r\n"
		+ " *     실행파일X\r\n"
		+ " *     텍스트파일  FileReader FileWriter\r\n"
		+ " *                        BufferedReader, BufferedWriter 보조 스트림\r\n"
		+ " *                        br.readLine()  한 라인 씩 처리..                                                          \r\n"
		+ " * */\r\n"
		+ "\r\n"
		+ "\r\n"
		+ "\r\n"
		+ "\r\n"
		+ "\r\n"
		+ "/*\r\n"
		+ " *                      [C 9 유용한 클래스 - 자주]    \r\n"
		+ " *                      C 10 날짜/시간 \r\n"
		+ " *                     C 11 컬렉션 프레임워크 \r\n"
		+ " *                     C 12 지네릭스,열거형, 어노테이션 @override\r\n"
		+ " *                     \r\n"
		+ " *                       ***** 월/화 C 15 입출력(I/O)  ***** \r\n"
		+ " *                      C 13 스레드\r\n"
		+ " *                      C 16 네트워크 (수)           팀프로젝트 - 목/금/토/일       (월) 발표 오라클 수업..\r\n"
		+ " */\r\n"
		+ "\r\n"
		+ " ";
/* 11번재 라인의 문자열 출력 
String[] lines=source.split("\n");
System.out.println(lines[10]);*/

//	int fromIndex=0, findIndex;	
//	int i=1;
//	while(i<=10) {
//		findIndex=source.indexOf("\r\n",fromIndex);
//		fromIndex=findIndex+1;
//	}
//	System.out.println(source.substring(findIndex));
//	
StringReader sr=new StringReader(source);
//라인단위로 처리하는 보조스트림 
BufferedReader br=new BufferedReader(sr);
int i=1;
while(i++<=10) {
	br.readLine();
}
System.out.println(br.readLine());

	} // main

} // class
