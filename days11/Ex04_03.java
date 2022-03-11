package days11;

/**
 * @author 지민
 * @date 2022. 3. 3. - 오후 3:47:30
 * @subject 
 * @content 
 * 
 */
public class Ex04_03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] m=new int[3];
m[0]=100;
m[1]=85;
m[2]=93;

{
	int [] temp=new int[5];
	for(int i=0; i<m.length; i++) {
		temp[i]=m[i];
	}
	m=temp;
}
 	}

}
