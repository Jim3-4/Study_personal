package days25;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 지민
 * @date 2022. 3. 24. - 오후 12:28:30
 * @subject 
 * @content 
 * 
 */
public class Ex09 {
public static void main(String[] args) {
	String[] m= {"tiger","cat","Dog","lion"};
	System.out.println(Arrays.toString(m));
	Arrays.sort(m);
	//내림차순 정렬
	Arrays.sort(m, new DesendingComparator());
	System.out.println(Arrays.toString(m));
	
	//대소문자 구분하지 않고 정렬
	Arrays.sort(m,String.CASE_INSENSITIVE_ORDER);
	System.out.println(Arrays.toString(m));
}}

class DesendingComparator implements Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return arg1.compareTo(arg1);
	}
	

	Person[] m= {
			new Person("백경환",24),
			new Person("깅이이이",22),
			new Person("용용이",12)
	};

}
class Person implements Comparable<Person>{
	String name;
	int age;
	public Person(String name, int age) {
		this.name=name;
		this.age=age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		//return this.age-o.age; // 같으면 0 앞이 크면 양 , 뒤가 크면 음 
		return this.name.compareTo(o.name)*-1;
	}
	
}
