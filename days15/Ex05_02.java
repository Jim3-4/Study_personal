package days15;

/**
 * @author 지민
 * @date 2022. 3. 10. - 오후 11:16:14
 * @subject 
 * @content 
 * 
 */
public class Ex05_02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person[] ps=new Person[5];
		for(int i=0; i<ps.length; i++) {
			ps[i]=new Person();
			ps[i].name=(i+1)+"번사람";
			ps[i].run();
		}
	}

}
