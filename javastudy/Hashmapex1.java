package hash;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 지민
 * @date 2022. 3. 26. - 오후 10:49:08
 * @subject 
 * @content 
 * 
 */
public class Hashmapex1 {
public static void main(String[] args) {
	HashMap map=new HashMap();
	map.put("myid", "1234");
	map.put("asdf","1111");
	map.put("asdf","1234");

	Scanner s=new Scanner(System.in);

	while(true) {
		System.out.println("id와 passwd를 입력하세요 ");
		System.out.println("id:");
		String id=s.nextLine().trim();
		
		System.out.println("password");
		String password=s.nextLine().trim();
		System.out.println();
		
		if(!map.containsKey(id)) {
			System.out.println("입력한 키는 존재하지 않습니다.");
			continue;
		}
		if(!map.get(id).equals(password)) {
			System.out.println("비밀번호가 일치하지 않스빈다.");
		}else {
			System.out.println("id랑 비밀번호가 일치합니다.");
			break;
		}
		
}
}
