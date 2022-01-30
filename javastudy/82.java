package twoInterface;

public class A {	
	public int field1=1;
	public void method1() {}
	
	static int field2=3;
	static void method2() {}
	
	class B{
		void method() {
			field1=10;
			method1();
			
			field2=33;
			method2();
		}
		
	static class C{
		void method2() {
			field2=145;
			method2();
		}
	}
	}
}
