package days25;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 지민
 * @date 2022. 3. 24. - 오전 11:29:25
 * @subject ArrayList , Vector , LinkedList , Stack , Queue(LinkedList) 
 * @content 
 * 
 */
public class Ex05 {
public static void main(String[] args) {
//우선권 	PriorityQueue 저장한것에 상관없이 우선권이 높은 것부터 꺼내온다. 
	//컬렉션 클래스 안에 Integer 값을 저장하겠다. 
	Queue<Integer> q=new PriorityQueue<Integer>();
	q.offer(3);
	q.offer(5);
	q.offer(2);
	q.offer(1);
	q.offer(4);
	
	System.out.println(q);
	
	while(!q.isEmpty()) {
		int n=q.poll();
		System.out.println(n);
	}
	
	
}
}
