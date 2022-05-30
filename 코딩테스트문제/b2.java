import java.io.*;

public class Main {
    public static void main(String[] args)  throws IOException{
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
        int cnt=0;
        while(true){
            if(n%5==0){
                cnt += num/5;
                System.out.println(cnt);
                return;
            }
            else{
                n -= 3;
                cnt++;
            }
            if(n<0){
                System.out.println(-1);
                     return;
            }
        }//while
    }//main
}//class 
