package days28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author 지민
 * @date 2022. 3. 29. - 오후 2:46:29
 * @subject 
 * @content 
 * 현재 사용중인 os의 인코딩확인
 */
public class Ex08_02 {
public static void main(String[] args) throws IOException {
//	InputStreamReader isr=new InputStreamReader(System.in);
//	System.out.println(isr.getEncoding());
//	//3바이트 읽어가는 방법 ?
//	InputStream is=System.in; ///바이트 스트림 
//	byte[] buf=new byte[3];
//	//int 읽은바이트수=isr.read(buf);
//	//byte->String.charAt(0)==>char
//	String s=new String(buf);
//	char one=s.charAt(0);
//	System.out.println(one);
	System.out.println("한문자입력");
	InputStream is=System.in; //바이트 스트림 
	//byte->char 문자보조스트림 
	InputStreamReader isr=new InputStreamReader(is);
	BufferedReader br=new BufferedReader(isr);
String data=br.readLine();
System.out.println(data);

	//System.out.println((char)b);
}
}
