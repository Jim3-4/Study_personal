package day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 지민
 * @date 2022. 2. 17. - 오후 3:35:53
 * @subject 
 * @content 
 * 
 */
public class Ex07_02 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int kor, eng, mat;
		double avg;
		short sum;
		System.out.println("국어점수를입력하세요 ");
		kor=Byte.parseByte(br.readLine());
		System.out.println("영어점수를입력하세요 ");
		eng=Byte.parseByte(br.readLine());
		System.out.println("수학점수를입력하세요 ");
		mat=Byte.parseByte(br.readLine());
		
		sum=(short)(kor+eng+mat);
		avg=(double)sum/3;
		System.out.printf("총점은 : %d, 평균은 : %f", sum,avg);
	}

}
