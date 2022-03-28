package days27;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author 지민
 * @date 2022. 3. 28. - 오후 4:36:32
 * @subject 
 * @content 
 * 
 */
public class Ex14 {
public static void main(String[] args) {
	String pathname=".\\src\\days27";
	File file=new File(pathname);
	File[] fileList=file.listFiles(new FilenameFilter() {
		
		@Override
		public boolean accept(File dir, String name) {
		
			return name.startsWith("Ex06");
		}
	});
	
	for (File file2 : fileList) {
		System.out.println(file2.getName());
	}
}
}
