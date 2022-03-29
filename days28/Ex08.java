package days28;

import java.io.InputStream;

/**
 * @author 지민
 * @date 2022. 3. 29. - 오후 2:32:09
 * @subject 
 * @content 
 * 
 */
public class Ex08 {
public static void main(String[] args) {
	String name;
//	System.out.println("이르입력");
//	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//	name=br.readLine();
//	System.out.println(name);
	InputStream is=System.in; //바이트 스트림 
	System.out.println("입력하세요");
int b=is.read();
char ch=(char)b;
System.out.println(ch);
}
}
