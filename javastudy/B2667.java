package days01;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class B2667 {
	static int area[][];
	static int N=0, count=0;
	static int[] moveX= {-1,0,1,0};
	static int[] moveY= {0,1,0,-1};
	static ArrayList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));


		N=Integer.parseInt(br.readLine());
		area=new int[N][N];
		for (int i = 0; i < N; i++) {
			String input=br.readLine();
			for (int j = 0; j <N; j++) {
				area[i][j]=input.charAt(j)-'0';
				//area[i][j]=Integer.parseInt(input.charAt(j)+"");
			}
		}//for-i
		
		count=0;
		list=new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(area[i][j]==1) {
					count=1;
					bfs(i,j);
					list.add(count);
				}
			}
		}//for-i
		Collections.sort(list); //오름차순 정렬 
		System.out.println(list.size()); 
	
		Iterator<Integer> ir =list.iterator();
		while(ir.hasNext()) {
			System.out.println(ir.next());
		}
	}

	public static int bfs(int i, int j) {
		area[i][j]=0;
		
		Queue<Point> que=new LinkedList<Point>();
		que.add(new Point(i,j));
		
		while(!que.isEmpty()) {
			Point p=que.poll();
		for (int k = 0; k < 4; k++) {
			int nx=p.x+moveX[k];
			int ny=p.y+moveY[k];
			
			if(nx>=0 && nx<N && ny >=0 && ny<N) {
				if(area[nx][ny]==1 ) {
					que.add(new Point(nx,ny));
					area[nx][ny]=0;
					count++;
				}
			}//if
		}//for-k
		}//while
		
		return count;
	}
}
