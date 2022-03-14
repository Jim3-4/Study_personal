package days17;

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

public Student() {}


public Student(int no, String name, int kor, int eng, int mat, int tot, int rank, double avg) {
	super();
	this.no = no;
	this.name = name;
	this.kor = kor;
	this.eng = eng;
	this.mat = mat;
	this.tot = tot;
	this.rank = rank;
	this.avg = avg;
}

public void printInfo() {
	System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n"
			, no, name , kor , eng,  mat , tot, avg, rank);
}
}
