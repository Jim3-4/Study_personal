package smhrd;
class Person{
	final String nation="korea";
	final String ssn;
	final String name;
	
	public Person(String ssn, String name){
		this.ssn=ssn;
		this.name=name;
	}
}

public class CalExam {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p1=new Person("980304","jiami");
				
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		 
	}

}
