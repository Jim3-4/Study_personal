package eightInterface;

public class interExam {

	public static void main(String[] args) {
		// TODO Acuto-generated method stub
		implementationC impl=new implementationC();
		
		interfaceA ia=impl;
		ia.methodA();
		System.out.println();
		
		interfaceB ib=impl;
		ib.methodB();
		System.out.println();
		
		interfaceC ic=impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();
				
	}

}
