package days24;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kenik
 * @date 2022. 3. 23. - 오후 4:22:56
 * @subject 
 * @content 
 */
public class Ex11 {

	public static void main(String[] args) {
		// <E> 삭제
		 List   list = new ArrayList();  // 중복 허용 O
		 list.add("박민주");  // 0
		 list.add("이동원");
		 list.add("마상민");
		 list.add("박민주");  // 3  중복
		 
		 System.out.println(  list );
		 
		 // 박민주 라는 요소를 찾는다. 
		 int findIndex = list.indexOf("박민주");
		 System.out.println(  findIndex );
		 
		 // [문제] "박민주"  모두 찾아서 인덱스을 출력.... 
		 ArrayList  findList =   myIndexOf( list, "박민주");
		 // "".indexOf(findIndex, fromIndex)
		 System.out.println(  findList);

	} // main

	private static ArrayList myIndexOf(List list, String name) {
		// int []  =  new int[??]
		ArrayList  findList=new ArrayList();
		
		for (int i = 0; i < list.size(); i++) {
			if( list.get(i).equals(name) ) {
				findList.add( i );
			}
		}
		
		return findList;
	}

} // class








