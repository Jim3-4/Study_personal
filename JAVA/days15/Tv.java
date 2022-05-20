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
	
	Tv t1=new Tv();
	t1.channel=11;
	t1.channelUp();
}	
