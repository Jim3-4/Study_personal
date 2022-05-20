package days21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kenik
 * @date 2022. 3. 18. - 오후 4:22:27
 * @subject   p 506 예제 9-32
 * @content 
 */
public class Ex11_02 {

	public static void main(String[] args) {
		// 수업 종료 후 주말 코딩.
		// p506
				String [] data = {"bat","baby","bonus","c", "cA","ca","co", "c." , "c0", "c#", "car", "combat", "count", "date", "disc"};
				// p507 표9-11 (꼭 이해하기)
				String [] pattern = { ".*", "c[a-z]*","c[a-z]","c[a-zA-z]", "c[a-zA-z0-9]","c.","c.*","c\\.","c\\w", "c\\d", "c.*t", "[b|c].*", ".*a.*",".*a.+","[b|c].{2}"
				}; 
				
				for (int x = 0; x < pattern.length; x++) {
					Pattern p = Pattern.compile(pattern[x]);
					System.out.print("Patterm :" + pattern[x] + " 결과 : ");
					for (int i = 0; i < data.length; i++) {
						Matcher m = p.matcher(data[i]);
						if (m.matches()) {
							System.out.print(data[i]+",");
						}
						System.out.println();
					}
				}

	} // main

} // class
