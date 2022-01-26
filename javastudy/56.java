
package two;

public class AnimalExample {
	public static void main(String[] args) {
		Dog dog=new Dog();
		Cat cat=new Cat();
		dog.sound();
		cat.sound();
		System.out.println("-----");
		
		
		Animal animal=null;
		animal=new Dog();
		animal.sound();
		animal=new Cat();
		animal.sound();
		System.out.println("-----");
		animalsound(new Dog());
		animalsound(new Cat());
	}
	public static void animalsound(Animal animal) {
		animal.sound();
	}
}
