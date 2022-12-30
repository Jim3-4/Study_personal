import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{

  private static final StringBuilder sb=new StringBuilder();
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
	  
    int N = Integer.parseInt(br.readLine());
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int[] arr = new int[N + 1];
    long[] sum = new long[N + 1];
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(stk.nextToken());
    }
    sum[1] = 0;
  // sum[2] = cal(1, 2, arr[1], arr[2]);
    for (int i = 2; i <= N; i++) {
      sum[i] = Long.MAX_VALUE;
      for (int j = 1; j < i; j++) {
        long k = cal(j, i, arr[i], arr[j]);
        k = Math.max(k, sum[j]); 
        sum[i] = Math.min(sum[i], k); 
      }
    }

    sb.append(sum[N]);
    System.out.println(sb.toString());
  }

  public static long cal(int i, int j, int s, int e) {
    return (long) (j - i) * (1 + Math.abs(s - e));
  }
}
