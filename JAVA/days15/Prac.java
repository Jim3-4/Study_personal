package days15;

/**
 * @author 지민
 * @date 2022. 3. 11. - 오전 8:20:30
 * @subject 
 * @content 
 * 
 */
 class Prac {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tv[] tvArr=new Tv[3];
		for(int i=0; i<tvArr.length; i++) {
			tvArr[i]=new Tv();
			tvArr[i].channel=i+10;
		}
	}
class Tv { //extends java.lang.Object 생략 
			
			 String color;
			boolean power;
			 int channel;
			Tv(){
				color="blue";
				
			}
			public void power() {
				power =!power;
			}
			 
			public void channelUp() {
				channel++;
			}
			public void channelDown() {
				channel--;
			}

		}
}
