import java.io.File;
package days27;

/**
 * @author 지민
 * @date 2022. 3. 28. - 오후 2:44:24
 * @subject 
 * @content 
 * 
 */
public class Ex08 {
public static void main(String[] args) {
	String pathname=".\\src\\days27\\Ex01.java";
	File f=new File(pathname);
//	System.out.println(f.exists()); //파일의 존재여부
	if(f.exists() && f.isFile()) {
		System.out.println(f.canRead());
		System.out.println(f.canWrite());
		System.out.println(f.canExecute());
		System.out.println(f.isHidden());
	}
}
}
