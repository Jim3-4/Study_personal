package days28;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author kenik
 * @date 2022. 3. 29. - 오후 12:20:30
 * @subject p 893 예제 15-14
 * @content  [ 정리 ]   
 *   SequenceInputStream 스트림 ?  InputStream 열거형 en
 *                        메모리 스트림 
 *     byte[] -> ByteArray[InputStream]                           제네릭 + 컬렉션 클래스  + 열거자 
 *     byte[] -> ByteArray[InputStream]                         Vector< ByteArray[InputStream]> vt = ;       en=     vt.elements()
 *     byte[]-> ByteArray[InputStream]
 *      
 *      SequenceInputStream sis = new SequenceInputStream(en);
 *      //
 *      while( sis.read() )   out.write( data);
 *      //
 *      ByteArrayOutputStream out;
 *      byte [] d = out.toByteArray();
 *      
 */
public class Ex05_02 {

	public static void main(String[] args) {
		// SequenceInputStream 예제
		byte [] a = { 0,1,2,3 };  // 메모리스트림 - 바이트배열
		byte [] b = { 4,5,6 };
		byte [] c = { 7,8,9 };
		
		Vector<ByteArrayInputStream> vt = new Vector<ByteArrayInputStream>();
		 vt.add( new ByteArrayInputStream(a) );
		 vt.add( new ByteArrayInputStream(b) );
		 vt.add( new ByteArrayInputStream(c) );		 
		 Enumeration<ByteArrayInputStream>  en = vt.elements();	
		 
		SequenceInputStream sis = new SequenceInputStream(en );		
		
		byte [] d = null;		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int data = 0;
		try {
			while (    (data = sis.read() ) != -1   ) {
				bos.write(data); 
			}
		} catch (IOException e) { 
			e.printStackTrace();
		} 
		d = bos.toByteArray(); 
		System.out.println(   Arrays.toString( d ));
		
		/*
		// byte [] d = { 0,1,2,3,4,5,6,7,8,9};
		byte [] d = new byte[ a.length + b.length + c.length];
		
		System.arraycopy(a, 0, d, 0, a.length);
		System.arraycopy(b, 0, d, 4, b.length);
		System.arraycopy(c, 0, d, 7, c.length);
		
		// d 처리
		*/

	} // main

} // class












