package two;

public class InstanceofExample {
public static void method1(Parent parent) {
	if(parent instanceof Child) {
		Child child =(Child) parent;
		System.out.println("method1-child로 변환성공");
	}else {
		System.out.println("method2-child로 변환안됨");
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent parent=new Child();
		method1(parent);
	}

}
