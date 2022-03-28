package days27;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 지민
 * @date 2022. 3. 28. - 오전 11:49:22
 * @subject 
 * @content 
 * 
 */
public class Ex06 {
public static void main(String[] args) {
	String pathname=".\\src\\days27\\Ex01.java";
	String copyPathname="C:\\Users\\kimjm\\OneDrive\\문서\\Exo1.java";
	String parent=".\\src\\days27\\";
	String child="Ex01.java";
	File f1=new File(pathname);
	//File f1=new File(parent, child);
	System.out.println(f1.isFile());
	System.out.println(f1.isDirectory());
	System.out.println(f1.length()+"bytes");
	System.out.println(f1.getName());
	System.out.println(File.separator);
	
	
	try (FileReader fr=new FileReader(f1);
			FileWriter fw=new FileWriter(copyPathname)
			){
		int c;
		while((c=fr.read())!=-1) {
			//System.out.printf("%c",(char)n);
			fw.write(c);
		}
		System.out.println("파일복사완료");
	} catch(FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}//main
}
