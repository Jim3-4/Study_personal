package days27;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 지민
 * @date 2022. 3. 28. - 오후 2:16:23
 * @subject 
 * @content 
 * 
 */
public class Ex07 {
public static void main(String[] args) {
	//  p915 file 클래스 설명-파일, 디렉토리 
	String currentDirectory=System.getProperty("user.dir");
//System.out.println(currentDirectory);
	File currDir=new File(currentDirectory);
//	String []    currDir.list();
//File[]	currDir.listFiles()
	File[] fileList=currDir.listFiles();
for (int i = 0; i < fileList.length; i++) {
	if(fileList[i].isDirectory()) {
		System.out.print("폴더");
	}else if(fileList[i].isFile()) {
		System.out.print("파일");
	}
	System.out.print("\t"+fileList[i].getName());

	long lm=fileList[i].lastModified();
	Date d=new Date(lm);
	String pattern="yyyy-MM-dd a hh:mm";
	SimpleDateFormat sdf=new SimpleDateFormat(pattern);
	System.out.print("\t"+sdf.format(d));
	
	if(fileList[i].isFile()) {
		System.out.print("\t"+fileList[i].length()+"bytes");
	}
	System.out.println();
}

}
}
