package days01;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B7562 {
	//X의 이동좌표
	static int[] moveX= {-2,-1,1,2,2,1,-1,-2};
	static int[] moveY= {1,2,2,1,-1,-2,-2,-1};
 	static int N; //한 변의 길이 
 	static int tc; //테스트 케이스 수 
 	static int[][] area; //칸 배열
 	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		tc=Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			N=Integer.parseInt(br.readLine());
			area=new int[N][N];
			st=new StringTokenizer(br.readLine(), " ");
			//현재 좌표
			int cx=Integer.parseInt(st.nextToken());
			int cy=Integer.parseInt(st.nextToken());
			Point cp=new Point(cx,cy);
			
			st=new StringTokenizer(br.readLine()," ");
			//목표 좌표 
			int tx=Integer.parseInt(st.nextToken());
			int ty=Integer.parseInt(st.nextToken());
			Point tp=new Point(tx,ty);
			
		System.out.println(	bfs(cp,tp,area));
		}
		
		bw.close();
		br.close();
	}

	private static int bfs(Point cp, Point tp, int[][] area) {
	
		Queue<Point> que=new LinkedList<Point>();
		que.add(cp);
		int nx = 0, ny=0;
		while(!que.isEmpty()) {
			Point p=que.poll();
			if(p.x==tp.x && p.y==tp.y) {
				return area[p.x][p.y];
			}
			for (int i = 0; i <8; i++) {
				nx=p.x+moveX[i];
				 ny=p.y+moveY[i];
				
				if(nx>=0 && nx<area.length && ny>=0 && ny<area.length&&area[nx][ny]==0) {
					
				
						area[nx][ny]=area[p.x][p.y]+1;
						que.add(new Point(nx,ny));
					

				}
			
			}//for
		}//while
		return -1;
		
	}

}
