package days27;

import java.io.File;

/**
 * @author 지민
 * @date 2022. 3. 28. - 오후 4:36:32
 * @subject 
 * @content 
 * 
 */
public class Ex13 {
public static void main(String[] args) {
	String pathname=".\\src\\days27";
	File file=new File(pathname);
	System.out.println(file.getAbsolutePath());
	//System.out.println(file.getCanonicalPath());
	System.out.println(file.getPath());
	
	File[] fileList=file.listFiles();
	for (int i = 0; i < fileList.length; i++) {
		if(fileList[i].isFile()) {
			String fileName= fileList[i].getName();
			System.out.println(fileName);
		}
		
	}
}
}
