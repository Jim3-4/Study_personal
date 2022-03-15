package days18;

/**
 * @author kenik
 * @date 2022. 3. 15. - 오후 4:49:12
 * @subject   p 390 인터페이스 사용하는 이유 즉, 장점.
 * @content 
 */
public class Ex16 {

	public static void main(String[] args) {
		// 1. 개발 시간을 단축
		//        예)  java 애플리케션     - 클래스,객체,물건 DBconn.java   -       DB		
		IDBconn dbconn = null;		
		dbconn.open();
		dbconn.insert();
		dbconn.close();
		// 2. 표준화가 가능하다. 
		
		// 3~~ 수업~~~

	} // main

} // class

// 인터페이스 만 선언
 
interface IDBconn{
	void open();
	void close();
	void insert();
	void select();
	void delete();
	void update();
}

//  표준화
class DBConn implements IDBconn{

	@Override
	public void open() { 
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}


/*
class DBConn{
	
	void db_open() {}
	void db_close() {
		
	}
	void exec_sql() {
		
	}
	
}
*/
/*
class DBConn{
	
	void getConnection () {
		//
	}
	
	void executeSQL() {
		
	}
	
}
*/
















