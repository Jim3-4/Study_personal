package twoInterface;

 class Outter {
	String field="Outter-field";
	 
	void method() {
		System.out.println("outter-method");
	}
	
	class Nested{
		String field1="nested-field";
		void method() {
			System.out.println("nested-method");
		}
		void print() {
			System.out.println(this.field1);
			this.method();
			System.out.println(Outter.this.field);
			Outter.this.method();
		}
	}
	
	public static void main(String args[]) {
		Outter outter=new Outter();
		Outter.Nested nested=outter.new Nested();
		nested.print();
		
	}
}
