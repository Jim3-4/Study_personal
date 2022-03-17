package days20;

/**
 * @author kenik
 * @date 2022. 3. 17. - 오후 12:16:19
 * @subject 
 * @content 
 */
public class Ex05 {

	public static void main(String[] args) {
		// p 463 [ Class 객체 ]를 얻는 3가지 방법 ***
		// 1) Class  getClass()
		/*
		Card c = new Card("HEART", 3);
		Class cls = c.getClass();
		System.out.println( cls.getName() );  // fullName
		System.out.println( cls.toString() );   // class days20.Card
		System.out.println( cls );
		*/
		
		// 2) 클래스명.class  --  static필드
		/*
		Class cls = Card.class;		
		// MyPoint.class
		// Class cls 인스턴스 생성할 수 있다.
		try {
			Card c = (Card) cls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) { 
			e.printStackTrace();
		}
		*/
		
		// 3) Class 클래스의 forName("full Name")   static메서드       
		try {
			Class cls =  Class.forName("days20.Card");   //   JDBC
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		}

	} // main

} // class

final class Card{
	String kind;
	int num;
	
	Card(){
		this("SPADE", 1);
	}

	public Card(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	
	@Override
	public String toString() {
		return this.kind +" : " + this.num;
	}
}












