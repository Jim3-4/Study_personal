package days15;

/**
 * @author 지민
 * @date 2022. 3. 10. - 오후 10:19:50
 * @subject 
 * @content 
 * 
 */
public class Student {
int no;
String name;
int kor, eng, mat, tot, rank;
double avg;

public void printInfo() {
	System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n"
			, no, name , kor , eng,  mat , tot, avg, rank);
}
}
