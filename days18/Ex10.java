package days18;

/**
 * @author kenik
 * @date 2022. 3. 15. - 오후 2:37:25
 * @subject   p 379 
 * @content 
 */
public class Ex10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

abstract class Unit{
	int x, y;  // 현재 위치 저장할 필드
	abstract void move(int x, int y);  
	abstract void stop()  ;
}


class Marine extends Unit{
//	int x, y;  // 현재 위치 저장할 필드
//	void move(int x, int y) {}
//	void stop() {}	
	void stimPack() {}  //
	@Override
	void move(int x, int y) { } 
	@Override
	void stop() { }
}

class Tank extends Unit{
//	int x,y;
//	void move(int x, int y) {}
//	void stop() {}
	
	void changeMode() {} //

	@Override
	void move(int x, int y) { } 
	@Override
	void stop() { }
}

class DropShip extends Unit{
//	int  x,y;
//	void move(int x, int y) {}
//	void stop() {}
	
	void load() {}
	void unload() {}
	@Override
	void move(int x, int y) { }
	@Override
	void stop() { }
}















