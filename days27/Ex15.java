package days27;

import java.io.File;

import com.util.FileUtil;

/**
 * @author 지민
 * @date 2022. 3. 28. - 오후 4:52:47
 * @subject 
 * @content 
 * 
 */
public class Ex15 {
public static void main(String[] args) {
	String pathname="\\src\\days27\\images";
	File f=new File(pathname);
	File[] flist=f.listFiles();
	for (int i = 0; i < flist.length; i++) {
		String fileName=flist[i].getName();
		String baseName=FileUtil.getBaseName(fileName);
		String ext=FileUtil.getExtension(fileName);
		String newBaseName=String.format("%04d", Integer.parseInt(baseName));	}
		String newFileName=String.format("%s%s", newBaseName,ext);
		flist[i].renameTo(newFileName);
}
}
