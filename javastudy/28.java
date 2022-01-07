package smhrd;
class Singleton{
	private static Singleton Singleton=new Singleton();
	
	private Singleton() {}
	
	static Singleton getInstance() {
		return Singleton;
	}
}

public class CalExam {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Singleton s1=Singleton.getInstance();
		Singleton s2=Singleton.getInstance();
		
		if(s1==s2) {
			System.out.println("같은객체");
		}
	    //에러 Singleton s2=new Singleton(); 
	}

}
