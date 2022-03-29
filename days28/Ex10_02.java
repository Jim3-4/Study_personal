package days28;

import java.io.RandomAccessFile;

/**
 * @author 지민
 * @date 2022. 3. 29. - 오후 4:07:25
 * @subject 
 * @content 랜덤하게 읽고 쓰기
 * 
 */
public class Ex10_02 {
    //4:05 수업시작~
    int [] score = {
          1,100,90,90,            
          2,70,90,100,
          3,100,100,100,
          4,70,60,80,
          5,70,90,100
    };
     
    String name = ".\\src\\days28\\score.dat";
    String mode = "rw";
    try( RandomAccessFile raf = new RandomAccessFile(name, mode)) {
       /*
       for (int i = 0; i < score.length; i++) {
          System.out.println("> 현재 FP : " + raf.getFilePointer()  + " - " + score[i] );
          raf.writeInt(     score[i]      );
       }
       
  
       System.out.println("> 엔터 치면 진행합니다. ");
       System.in.read();
       System.in.skip( System.in.available() ); 
       
       // [문제] 3 번 학생의 번호,국어,영어,수학 성적 정보만 출력.
       int pos = ( 4+4+4+4 ) * 2;  // 32 
       raf.seek(pos);
          int no = raf.readInt();
          int kor = raf.readInt();
          int eng = raf.readInt();
          int mat = raf.readInt();
       System.out.printf("번호:%d, 국어:%d, 영어:%d, 수학:%d\n", 
                                        no, kor, eng, mat);
       
       System.out.println("> 엔터 치면 진행합니다. ");
       System.in.read();
       System.in.skip( System.in.available() ); 
       
       // [문제]  3번 학생의 [ 수학점수를 20점] 으로 수정
       pos = ( 4+4+4+4 ) * 2 + ( 4+4+4) ;  // 44
       raf.seek(pos);
       raf.writeInt(20); 
       
       System.out.println("> 엔터 치면 진행합니다. ");
       System.in.read();
       System.in.skip( System.in.available() ); 
       */
       // [모든] 모든 학생의 정보를 출력..... 번호/국/영/수
       raf.seek(0);  // 파일포인터 처음으로 이동.. 
       
       for (int i = 0; i < score.length; i++) { 
          int info = raf.readInt(           );
          System.out.print(  info+"\t" );
          if( (i + 1)%4 ==0   ) System.out.println();
       }
       // 0 1 2 3  개행
       // 4 5 6 7 개행
       
       // p934 직렬화 ~ (정독)
    } catch (Exception e) {
       e.printStackTrace();
    }
    

}
}
