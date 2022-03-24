package days25;

/**
 * @author 지민
 * @date 2022. 3. 24. - 오전 9:46:53
 * @subject 
 * @content 
 * 
 */
public class Ex02 {
public static void main(String[] args) {
	//
	Node node1=new Node();
	node1.value=10;
	
	
	
	Node node2=new Node();
	node2.value=20;

	Node node3=new Node();
	node3.value=20;
	
	Node node4=new Node();
	node4.value=20;
	
	node1.next=node2; //다음주소를  참조 시키겠다. 
	node2.next=node3;
	node3.next=node4;
	node4.next=null;
	
	Node node=node1;
	
	while(node!=null) {
	System.out.println(node.value);
	node=node.next; //다음노드 
	}
	
}
}

class Node{
	int value; // 값 

	//다음() 노드의 주소값을 참조변수 
	Node next=null; //단방향 
	//Node prev=null; //양방향 
}
