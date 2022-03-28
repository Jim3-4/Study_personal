package days27;

import java.io.File;
import java.io.IOException;

/**
 * @author 지민
 * @date 2022. 3. 28. - 오후 3:37:22
 * @subject 
 * @content 
 * 
 */
public class Ex11 {
public static void main(String[] args) {
	//C:\\upload 폴더가 있는지 확인후에 없으면 생성 
	
	String pathname="C:\\Users\\kimjm\\OneDrive\\문서\\upload\\2022-03-28";
	File file=new File(pathname);
	if(!file.exists()) {
		try {
			System.out.println(file.mkdir());
			//System.out.println(file.createNewFile());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
}