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
public class Ex12 {
public static void main(String[] args) {
	//C:\\upload 폴더가 있는지 확인후에 없으면 생성 
	
	String pathname="C:\\Users\\kimjm\\OneDrive\\문서\\upload\\2022-03-28";
	File file=new File(pathname);
	System.out.println(file.delete());
	directoryDelete(file);
}//main

private static void directoryDelete(File file) {
	// TODO Auto-generated method stub
	  while(!file.delete()) {
          
          File[] files=file.listFiles();
          
          for (int i = 0; i < files.length; i++) {
              if(!files[i].delete()) {
                 directoryDelete(files[i]);
              }else {
                 System.out.printf("%s 삭제가 완료되었습니다.\n",files[i]);
              } // if
          } // for
       } // method
       
       System.out.printf("%s 삭제가 완료되었습니다.\n",file);
       

}
}//class