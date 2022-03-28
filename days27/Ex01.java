package days27;

import java.util.ArrayList;

/**
 * @author 지민
 * @date 2022. 3. 28. - 오전 9:21:16
 * @subject 
 * @content 
 * 
 */
class Fruit { public String toString() {return "Fruit";}}
class Apple extends  Fruit { public String toString() {return "apple";}}
class Grape extends Fruit { public String toString() {return "grape";}}

class Juice{
	String name;
	Juice(String name){this.name=name;}
	public String toString() {return name;}
}
class Juicer{
	static Juice makeJuice(FruitBox<? extends Fruit> box) {
		String tmp=" ";
		for(Fruit f: box.getList()) {
			tmp+=f+" ";
		}
		return new Juice(tmp);
	}
}

public class Ex01 {
public static void main(String[] args) {
	// 제네릭 메서드 / 메서드 선언부에 제네릭 타입이 선언된 메서드 
	//제네릭 타입의 선언 위치는 리턴자료형 앞에 선언
	//접 기 T 리 메서드명 
	
	FruitBox<Apple>  appleBox=new FruitBox<>();
	Juice appleJuice=Juicer.makeJuice(appleBox);
	
	FruitBox<Grape> grapeBox=new FruitBox<>();
	Juice a=Juicer.<Grape>makeJuice(grapeBox);
	
	
}
}
class FruitBox<T extends Fruit> extends Box<T>{}
class Box<T>{
	ArrayList<T> list=new ArrayList<>();
	void add(T item) {list.add(item);}
	T get(int i) {return list.get(i);}
	ArrayList<T> getList(){return list;}
	int size() {return list.size();}
	public String toString() {return list.toString();}
}
