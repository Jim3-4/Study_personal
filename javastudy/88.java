package twoInterface;

public class ClassCastEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog=new Dog();
		ChangeDog(dog);
		
		Cat cat =new Cat();
		ChangeDog(cat);
	}
	public static void ChangeDog(Animal animal) {
		if(animal instanceof Dog) {
			Dog dog=(Dog)animal;
		}
	}

}
class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}
