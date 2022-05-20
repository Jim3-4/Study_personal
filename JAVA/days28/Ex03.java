package days28;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author kenik
 * @date 2022. 3. 29. - 오전 10:23:51
 * @subject   p 847 바이트스트림  
 * @content    바이트 배열을 다루는 [메모리 스트림] - 성능(읽기,쓰기)
 *                        ByteArrayInputStream
 *                        ByteArrayOutputStream
 */
public class Ex03 {

	public static void main(String[] args) {
		
		byte [] insrc  = {  0, 1,2,3,4,5,6,7,8,9} ;
		byte [] outsrc = null;
		/*
		for (byte b : insrc) {
			System.out.println( b );
		}
		*/
		
	 
		try (
				//  바이트배열을 다루는   메모리 스트림
				ByteArrayInputStream bais = new ByteArrayInputStream( insrc );
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				)  {			
			//outsrc = new byte[  insrc.length  ] ;
			//int idx = 0;			
			int b ;
			while(     ( b= bais.read() )   != -1    ) {				
				// System.out.println(  b );
				//outsrc[idx++] = (byte)b;
				baos.write(b);				
			} // while			
			//System.out.println( Arrays.toString(outsrc));			
			outsrc = baos.toByteArray();
			System.out.println( Arrays.toString(outsrc));
		} catch (Exception e) {
			e.printStackTrace();
		}
	 
		
		// [][][][][][][]   -> bais 메모리스트림         -> while(  b  = read() != -1 )       
		// null
		//                                 baos 메모리스트림                            baos.write( b );
		//  outsrc =  baos.toByteArray();
		//  outsrc 출력

	} // main

} // class












