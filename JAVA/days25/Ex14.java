package days25;

import java.util.ArrayList;

/**
 * @author 지민
 * @date 2022. 3. 24. - 오후 4:29:05
 * @subject 
 * @content 
 * 
 */
public class Ex14 {
public static void main(String[] args) {
	final int LIMIT=10;
	String source="0123456789abcdefghigeuiruwoe";
	int length=source.length();
	ArrayList list=new ArrayList(length/LIMIT+10);
	for (int i = 0; i < length; i+=LIMIT) {
		if(i+LIMIT<length) {
			list.add(source.substring(i,i+LIMIT));
		}else {
			list.add(source.substring(i));
		}
	}
	for (int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i));
	}
	
	
}//main
}//class