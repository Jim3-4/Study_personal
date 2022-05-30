import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class b설탕 {
    public static void main(String[] args)  throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int cnt=0;
        while(true){
            if(n%5==0){
                cnt+=n/5;
                System.out.println(cnt);
                return;
            }
            else{
                n-=3;
                cnt++;
            }
            if(n<0){
                System.out.println(-1);
                return;
            }
        }
    }
}
