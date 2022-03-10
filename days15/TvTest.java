package days15;

/**
 * @author 지민
 * @date 2022. 3. 10. - 오전 10:08:44
 * @subject 
 * @content 
 * 
 */
 class Tv { //extends java.lang.Object 생략 
	
	public String color;
	public boolean power;
	public int channel;
	
	void power() {
		power =!power;
	}
	 
	void channelUp() {
		channel++;
	}
	void channelDown() {
		channel--;
	}

}
 class TvTest3{
	 public static void main(String[] args) {
		Tv t1=new Tv();
		Tv t2=new Tv();
		System.out.println(t1.channel);
		System.out.println(t2.channel);
		
		t2=t1; //t1이 저장하고 잇는 주소를 t2에 저장한다. 
		t1.channel=7;
		System.out.println(t1.channel);
		System.out.println(t2.channel);
	}
 }
