package days18;

/**
 * @author kenik
 * @date 2022. 3. 15. - 오후 4:35:33
 * @subject   p 388 예제 7_25  [인터페이스 다형성 설명 예제]
 * @content 
 */
public class Ex15 {

	public static void main(String[] args) {
		// 인터페이스 업캐스팅
		Parseable parser = ParserManger.getParser("HTML");
		
		parser.parse("document.html");
		
		//
		//
				

	} // main

} // class

interface Parseable{
	//  구문 분석하는 메서드 
	void parse(String fileName);
}

// ???.xml
class XMLParser implements Parseable{

	@Override
	public void parse(String fileName) { 
		System.out.println("XML 파일 구문 분석 메서드");
	}
	
}

// ???.htm
class HTMLParser implements Parseable{

	@Override
	public void parse(String fileName) {
		System.out.println("HTML 파일 구문 분석 메서드");
	}
	
}

// 인터페이스 업캐스팅
// Parseable p = new XMLParser();

class ParserManger{
	                  // [인터페이스]가 리턴자료형
	public static Parseable getParser( String type) {
		if( type.equals("XML")) {
			return new XMLParser(); // 
		}else {
			return new HTMLParser(); // 
		}
	}
	
}














