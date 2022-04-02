//package tennis;
//
//import java.util.Scanner;
//
///**
// * @author 지민
// * @date 2022. 3. 31. - 오후 8:54:15
// * @subject 
// * @content  입력받을 변수를 만들지 않음 
// * 
// */
//public class GameSetting3 extends Player{
//	
//	Scanner sc=new Scanner(System.in);
//	public GameSetting3(String[] name, int setNum, int gender, int mode) {
//		super(name, setNum, gender, mode);
//	}
//	
//	public void InfoGame(){
//		
//		do {
//			System.out.println("[경기방식을 입력해주세요 ]: 1. 단식 2.복식");
//			 mode=sc.nextInt();
//		} while (!(mode==1 ||mode==2)); //입력된 것이 1,2가 아니면 다시 
//		this.setMode(mode);
//		//복식이라면 남녀 혼합인지 아닌지 
//				if(mode==2) {
//					System.out.println("남녀 혼합 복식인가요 ? 1.네 2.아니오 ");
//					int mixCheck=sc.nextInt();
//					if(mixCheck==1) gender=3; 
//				}//if
//		String[] name=new String[mode*2];
//		
//	
//		do {
//			System.out.println("[성별을 입력해주세요 ]1:남자 2:여자 3: 남녀혼합 > ");
//			 gender=sc.nextInt();
//		}while(!(gender==1 ||gender==2|| gender==3));
//		this.setGender(gender);
//		
//
//		do {
//			System.out.println("[세트수를 입력해주세요 ]1:3세트 2:5세트 > ");
//			 setNum=sc.nextInt();
//			 if(setNum==1) { gender=2; //3세트면 여자 
//			 }else {gender=1; //5세트면 남자
//			 }//if-else 
//			 }//do
//			 while(!(setNum==1 ||setNum==2));
//		this.setSetNum(setNum);
//		
//		
//		
//		for (int i = 0; i < name.length; i++) {
//			System.out.printf("%d번째 선수 이름을 입력해주세요",i+1);
//			name[i]=sc.next();
//		}
//		this.setName(name);
//		
//		
//	}//infoGame()
//	}//class -GameSetting
//
