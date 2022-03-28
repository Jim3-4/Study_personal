package days27;

import java.io.File;

import com.util.FileUtil;

/**
 * @author 지민
 * @date 2022. 3. 28. - 오후 3:31:52
 * @subject 
 * @content 
 * 
 */
public class Ex10 {
public static void main(String[] args) {
	//com.util.FileUtil.java
	//path=C:\SS16Class5\JavaClass\JavaPro
	String path=System.getProperty("user.dir")+"\\src\\day02\\Ex07.java";
	//System.out.println(path);
	File f=new File(path);
	//파일명만 필요할때는 getName
	String fileName=f.getName();	
	System.out.println(fileName);
	//2 확장자
	String ext=FileUtil.getExtension(f);
	System.out.println(ext);
	//3 확장자 제거한 순수파일명
	String d=FileUtil.getBaseName(fileName);
	System.out.println(d);
	
	
}//main
}//class
