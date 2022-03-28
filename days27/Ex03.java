package days27;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 지민
 * @date 2022. 3. 28. - 오전 10:21:24
 * @subject 
 * @content 
 * 
 */
public class Ex03 {
public static void main(String[] args) {
	
	ArrayList<Student> list=new ArrayList<>(30);
	list.add(new Student(1, "유환재", 90, 89, 78, 257, 85.66, 1) );
    list.add(new Student(2, "박재영", 80, 89, 78, 247, 82.66, 1));
    list.add(new Student(3, "도성한", 90, 99, 78, 267, 88.66, 1));
    
    System.out.println("모든 학생정보 출력");
    Iterator<Student> ir=list.iterator();
    while (ir.hasNext()) {
		Student s=ir.next();
		System.out.println(s);
	}
    list.sort(new StudentComparator());
}//main
}//class
class StudentComparator implements Comparator<Student>{
	private StudentSortOptions sortOption;
	
	public int compare(Student o1, Student o2) {
		String name1=o1.getName();
		String name2=o2.getName();
		return name1.compareTo(name2);
		
	}
}
enum StudentSortOptoins{SCORE,NAME,NO};
c
class Student{
	private int no,kor,eng, mat,tot, rank;
	private String name;
	private double avg;

	public Student() {
		super();
	
	}

	public Student( int no,String name, 
			int kor, int eng, int mat, 
			int tot, double avg,
			int rank) {
		super();
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = tot;
		this.rank = rank;
		this.name = name;
		this.avg = avg;
	}

	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	/**
	 * @return the kor
	 */
	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	/**
	 * @return the eng
	 */
	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	/**
	 * @return the mat
	 */
	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	/**
	 * @return the tot
	 */
	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the avg
	 */
	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot=" + tot + ", rank="
				+ rank + ", name=" + name + ", avg=" + avg + "]";
	}
	
}