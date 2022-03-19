package days21;

/**
 * @author 지민
 * @date 2022. 3. 18. - 오후 5:12:42
 * @subject 
 * @content 
 * 
 */
public class Prac {
public static void main(String[] args) {
for (int i = 0; i < 10;i++) {
	System.out.print(getRand(1,10)+" ");
}
int[] result=fillRand(new int[10], new int[]{2,3,4,5});
int[] result2=fillRand(new int[3],3,5);
}


private static int[] fillRand(int[] is, int i, int j) {
	// TODO Auto-generated method stub
	for (int k = 0; k < is.length; k++) {
		is[k]=getRand(i,j);
	}
	return is;
}

private static int[] fillRand(int[] is, int[] is2) {
	// TODO Auto-generated method stub
	for (int i = 0; i < is.length; i++) {
		is[i]=is2[getRand(0,is2.length)];
	}
	return is;
}

private static int getRand(int i, int j) {
	// TODO Auto-generated method stub
return (int)(Math.random()*(Math.abs(i-j)+1))+Math.min(i, j);
}}
