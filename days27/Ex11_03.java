package days27;

import java.io.File;

/**
 * @author 지민
 * @date 2022. 3. 28. - 오후 4:07:44
 * @subject 
 * @content 
 * 
 */
//삭제하고자 하는 폴더의 aaa,bbb와 같은 하위폴더 가 있는 경우 
public class Ex11_03 {
public static void main(String[] args) {
	//문제점=하위폴더가 있는 경우는 삭제가 x
	//모든 하위폴더 삭제를 한후 -> upload 폴더도 삭제
	String pathname="C:\\Users\\kimjm\\OneDrive\\문서\\upload\\2022-03-28";
	
	File file=new File(pathname);
	System.out.println(file.delete());
	
	// 삭제하는 메소드를 만들어서 재귀 메소드 
	
}
}
