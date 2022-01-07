package smhrd;
class Single{
	private static Single Single=new Single();
	
	private Single() {}
	
	static Single getInstance() {
		return Single;
	}
}

public class CalExam {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Single s1=Single.getInstance();
		Single s2=Single.getInstance();
		
		if(s1==s2) {
			System.out.println("같은객체");
		}
	    //에러 Singleton s2=new Singleton(); 
	}

}
