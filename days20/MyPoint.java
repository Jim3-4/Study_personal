package days20;

public class MyPoint implements Cloneable{
 
	private int x = 0;
	private int y = 0; 
	 
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("> MyPoint 2 생성자 호출됨.");
	}
	
	public MyPoint() { 
		System.out.println("> MyPoint  디폴트 생성자 호출됨.");
	}

	public MyPoint(int x) { 
		this(x, 100);   
		System.out.println("> MyPoint 1 생성자 호출됨."); 
	}
  
	public MyPoint(MyPoint p) {
		x = p.x;
		y = p.y;
	}

	// getter, setter 선언 + 자동 생성  ( Alt + Shift + S 단축키 암기)
	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		// ***** this 키워드 ? 
		if ( x >= -100 && x <= 100) {
			this.x = x;
		} else {
			System.out.println("X의 유효범위가 벗어났다.");
		}
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	// 메서드 ( method )
	/*
	public void dispPoint() {
		System.out.printf("> x=%d, y=%d\n", this.x, this.y);
	}
	 */
	
	@Override
	public String toString() { 
		return String.format("> x=%d, y=%d\n", this.x, this.y);
	}

	// offsetPoint() 메서드를 호출한 객체 즉, p1 이  this 이다. 
	// p1.offsetPoint(5);
	// this.x 란 ?  p1의 x 필드
	public void offsetPoint(int pos) {
		this.x += pos;
		this.y += pos;
	}
	
	// this == p1
	// p1.offsetPoint(p2);
	// p1.x=15, y =105              x=16, y=107
	// p2.x=1 , y = 2                  x=1   y=2
	/*
	public void offsetPoint(MyPoint p) {
		this.x += p.x;
		this.y += p.y;
	}
	*/
	
	// [암기]
	// 오버로딩 -메서드명 동일, 매개변수 갯수, 타입 달라야 된다.
	//               리턴자료형만 다르다고 오버로딩 되지는 않는다. 
	// p1.offsetPoint(p2);
	public MyPoint offsetPoint(MyPoint p) {
		this.x += p.x;
		this.y += p.y;
		
		// return p;
		return this;  // this의 3번째 용도
	}

	// x,y 값같으면 같은 객체 true
	// p1.equals(p2)
	// this == p1
	// obj  == p2
	@Override
	public boolean equals(Object obj) {		  // Object obj = new MyPoint(1,2)
		// obj.메서드() - Object
		if(   obj  instanceof MyPoint ) {
			// obj.메서드() + MyPoint 이해
			MyPoint   p = (MyPoint)obj; 
			if( this.x == p.x && this.y == p.y   )    	return true;  
		}		
		return false;
	}

	  // p1.clone();
	@Override
	public  MyPoint clone()  { // throws CloneNotSupportedException
		Object obj = null;
		
	    // MyPoint p = new MyPoint( this );
	    
	    try {
			obj = super.clone(); // 예외 발생
		} catch (CloneNotSupportedException e) { 
			e.printStackTrace();
		}
	    
		return (MyPoint)obj;
	} 

} // MyPoint








