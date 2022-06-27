package days04;
public class SalgradeDTO {
private int grade;
private int losal;
private int hisal;
private int cnt; //해당부서에 있는 수를, 디비에는 없지만 추가

public SalgradeDTO() {
	super();
}

public int getCnt() {
	return cnt;
}

public SalgradeDTO(int grade, int losal, int hisal, int cnt) {
	super();
	this.grade = grade;
	this.losal = losal;
	this.hisal = hisal;
	this.cnt = cnt;
}

public void setCnt(int cnt) {
	this.cnt = cnt;
}

public SalgradeDTO(int grade, int losal, int hisal) {
	super();
	this.grade = grade;
	this.losal = losal;
	this.hisal = hisal;
}
public int getGrade() {
	return grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}
public int getLosal() {
	return losal;
}
public void setLosal(int losal) {
	this.losal = losal;
}
public int getHisal() {
	return hisal;
}
public void setHisal(int hisal) {
	this.hisal = hisal;
}
@Override
public String toString() {
	return String.format("%d 등급 ( %d ~%d) -%d명", grade,losal,hisal, cnt);

}}
