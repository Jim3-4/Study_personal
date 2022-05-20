package days28;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 지민
 * @date 2022. 3. 29. - 오후 3:25:55
 * @subject 
 * @content 
 * 
 */
public class Ex09 {
public static void main(String[] args) {
	System.out.println("AAA");
	System.out.println("BBB");
	System.out.println("CCC");
	System.out.println("DDD");
	System.err.println("EEE");

int input=0;
InputStream is=System.in;
try {
	while((input=is.read())!=-1) {
		System.out.println("input"+input+(char)input+(char)input);
	}
	}catch(IOException e){
		e.printStackTrace();
	}

	
	}}
