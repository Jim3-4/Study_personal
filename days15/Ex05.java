package days15;

/**
 * @author 지민
 * @date 2022. 3. 10. - 오후 2:03:10
 * @subject 
 * @content 
 * 
 */
public class Ex05 {
public static void main(String[] args) {
Person[] ps=new Person[5];
for(int i=0; i<ps.length; i++) {
	ps[i].name=(i+1)+"번 사람 ";
	ps[i].run();
	
}
	
}
}
