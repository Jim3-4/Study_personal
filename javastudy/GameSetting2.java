//package tennis;
//
//import java.util.Scanner;
//
///**
// * @author 지민
// * @date 2022. 3. 31. - 오후 8:54:15
// * @subject 
// * @content while 
// * 
// */
//public class GameSetting2 extends Player{
//	
//	Scanner sc = new Scanner(System.in);
//	public GameSetting2(String[] name, int setNum, int gender, int mode) {
//		super(name, setNum, gender, mode);
//	}
//
//	public void infoGame() {
//		// 게임 mode -단식인지 복식인지 
//		System.out.print("[경기방식을 입력해주세요 ]: 1. 단식 2.복식 >");
//		int sMode = sc.nextInt();
//		while (!(sMode == 1 || sMode == 2)) {
//			System.out.println("입력이 틀렸습니다. ,다시입력해주세요 ");
//			System.out.print("[경기방식을 입력해주세요 ]: 1. 단식 2.복식 >");
//			sMode = sc.nextInt();
//		}
//		this.setMode(sMode);
//		
//		//복식이라면 남녀 혼합인지 아닌지 
//		if(mode==2) {
//			System.out.println("남녀 혼합 복식인가요 ? 1.네 2.아니오 ");
//			int mixCheck=sc.nextInt();
//			if(mixCheck==1) gender=3; 
//		}//if
//		
//		// 세트수 입력받기 
//		System.out.print("[세트수를 입력해주세요] 1:3세트 2:5세트 >");
//		int sNum= sc.nextInt();
//
//		while (!(sNum == 1 || sNum == 2)) {
//			System.out.println("입력이 틀렸습니다. ,다시입력해주세요");
//			System.out.print("[세트수를 입력해주세요 ]1:3세트 2:5세트 >");
//			sNum=sc.nextInt();
//		}
//		this.setSetNum(sNum);
//		 if(sNum==1) { gender=2; //3세트면 여자 
//		 }else if(sNum==2) {gender=1; //5세트면 남자
//		 }//if-else 
//		
//		// 이름을 저장할 배열의 크기
//		String[] name = new String[mode * 2];
//
//		// 선수 이름 입력
//		for (int i = 0; i < name.length; i++) {
//			System.out.printf("%d번째 선수 이름을 입력해주세요",i+1);
//			name[i] = sc.next();
//		}
//		
//	}//infoGame()
//	}//class -GameSetting
//
