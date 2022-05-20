package days18;

public interface PlayingCard {
	// 상수
	public static final  int CLOVER = 1;
	int HEART = 2;  // public static final 생략 가능
	int DIAMOND = 3;
	int SPADE = 4;

	// 추상메서드
	public abstract String getCardNumber();
	String getCardKind();  // public abstract  생략 가능
	
	// [ JDK 1.8  부터 ] 왜 ?  
	// static 메서드 추가
	// 디폴트 메서드 추가
}
