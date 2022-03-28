package days27;

/**
 * @author 지민
 * @date 2022. 3. 28. - 오전 9:55:33
 * @subject 
 * @content 
 * 
 */
public class Ex02_02 {
public static void main(String[] args) {
Card c=Card.HEART;
System.out.println(c.toString());
System.out.println(c.name());
System.out.println(c.ordinal());

Card[] cArr=Card.values();

for (Card card : cArr) {
	System.out.printf("%s=%d",card.name(), card.ordinal());

}
}
}

