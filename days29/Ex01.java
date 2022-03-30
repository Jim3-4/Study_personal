package days29;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author kenik
 * @date 2022. 3. 30. - 오전 5:56:30
 * @subject 
 * @content 
 */
public class Ex01 {

	public static void main(String[] args) {
		// >29	2022-03-30(수)<   유환재, 이동원
		// p 934  직렬화( Serialization ) :  객체 -> 스트림 변환            이유? 자바 입출력
		//             ㄴ 객체 단위로 입출력을 하기 위해서 직렬화를 한다.
		//              ㄴ 직렬화 -> 역직렬화(  스트림-객체 변환 )         객체를 사용...

		// 한 멤버의 정보를 [네트워크 전송]/파일 저장
		
		Member m1 = new Member("박단", 25, false, 2);

		String fileName = ".\\src\\days29\\member.txt";
		
		/*  멤버 정보를 파일에 저장  
		try (FileWriter fw = new FileWriter(fileName )) {
			
			fw.write(m1.toString());
			fw.flush();  // 저장, 전송
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    */
		
		// 멤버 정보를 파일 읽기
         try ( FileReader fr = new FileReader(fileName );
        		 BufferedReader br = new BufferedReader(fr)) {
			String line ;
        	 while( (line = br.readLine() ) != null ) {
        		//System.out.println( line );
        		 // String line => Member m 객체 변환
	        		 String [] datas =  line.split(",");
	        		 String name = datas[0];
	        		 int age =  Integer.parseInt( datas[1] );
	        		 boolean gender =  Boolean.parseBoolean( datas[2] );
	        		 long type = Long.parseLong(datas[3]);
        		 Member m = new Member(name, age, gender, type);
        		 
        		 System.out.println(  m );
        	 } // while
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		System.out.println("END");
	} // main

} // class

/*
class Member{
	
	// field
	private String name;
	private int age;
	private boolean gender;
	private long type;
	
	// contructor
	public Member() {}

	public Member(String name, int age, boolean gender, long type) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.type = type;
	}

	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("%s,%d,%b,%d", name, age, gender, type);
	} 
	
} // class
*/








// [ 질문 ] flush() ,  close() 차이점
// [ 질문 ]  BufferedReader br =  new BR( ,   BUFFER_SIZE );
//               char [] buffer = new char [ BUFFER_SIZE ];  // 1024
//                while(   읽은바이트수= br.read(buffer) )
//                     bw.write( buffer, 0, 읽은바이트수 );







//1. 이틀동안 프로젝트 .. + 팀
		// 2. 팀 협업
		// 3. 프로젝트 
		//    ㄱ. 나의 현 실력(수준) 파악
		//    ㄴ. 배운 자바 과정의 총 정리
		//    ㄷ. 취업 - 포트폴리오 사용 ***
		//         [  자바프로젝트 ]
		//           1) 객체 지향적 프로그래밍
		//                            순서도
		//           2) 클래스 설계 + 구현
		//              ------------>  UML  클래스 다이어그램
		//              요구분석서 
		//              선수 클래스 : 속성, 기능
		//    ㄹ. 어려운 점 -> 해결 -> 각오






//  [ObjectInputStream   ObjectOutputStream]
// 객체  바이트스트림
// 1. 객체 직렬화 ( Object Serialization ) /  객체 역직렬화
// 2. 우리는 객체를 직/역 필요성 있다고 하더라.. ( 통신 )
// 3. 자바에는 객체를 어떻게 직렬화 하는가 ? 방법
//     ㄱ. serializable 인터페이스를 구현
//           메서드를 구현할 필요없이 단지 사용만 하면 된다. 
//           static 필드는 직렬화 되지 않습니다. ( 기억) 
//           transient 키워드를 붙인 필드는 직렬화 되지 않습니다. (기억)

//     ㄴ. externalizable 인터페이슬 구현
//                  readExternal()
//                  writeExternal()  개발자 직접 구현 필요성.
// 4. 메서드 + 생성자 직렬화 되지 않습니다.
// 5. 객체를 직렬화하면 파일 저장 또는 네트웤으로 전송할 때
//    손쉽게 읽기/쓰기 작업을 할 수 있다. 

// 6.  [ObjectInputStream   ObjectOutputStream] + 객체 직렬화가 필요.


// 2. 채팅 로그인 ( 통신규약 ) 
//    id [        ]  passwd [      ]   [로그인]
//    LOGNON01 /   kenik  /   1234
//    LOGNON02 /
//    LOGNON03 /
//    LOGNON04 /그룹/친구[차]/접속여부[활/부]
