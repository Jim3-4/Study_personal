package twoInterface;

import java.util.Scanner;

public class Test {
	 static Scanner sc = new Scanner(System.in);
	 static final int MIN = 2;
	 static final int MAX = 9;
	 public static void main(String args[]) {
		
		 int D1=MIN, D2=MAX;
		  
		  System.out.println("시작할 단을 입력해주세요");
		  D1 = sc.nextInt();
		  while(D1<MIN || D2>MAX){
		   System.out.println("다시 입력해주세요 " + MIN +"단 부터" + MAX + "단 까지 입력가능합니다.");
		   D1 = sc.nextInt();
		  }
		  
		  System.out.println("끝나는 단을 입력해주세요");
		  D2 = sc.nextInt();
		  while(D2<MIN || D2>MAX){
		   System.out.println("다시 입력해주세요 " + MIN +"단 부터" + MAX + "단 까지 입력가능합니다.");
		   D2 = sc.nextInt();
		  } 
		  
		  if(D1>D2){
		   int tmp =D1;
		   D1= D2;
		   D2 = tmp;
		  }
		  
		  for (int dan = D1; dan <= D2; dan += 3) {
			   
			   System.out.println();
			   for(int i=1; i<=9; i++){
				 
			    for(int j =0; j<3; j++){
			    if((dan+j)==i) {System.out.print("\t"); continue;}
			     String str = (dan+j) + "X" + i + "=" + (dan+j)*i;
			     System.out.print(dan+j<10 && dan+j <=(D2)? str + "\t" : "");
			     }
			    System.out.println();
			   }
			  }
		  
		  

	
}}
