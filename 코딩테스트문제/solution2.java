import java.util.Arrays;

class solution2{

    public static int[] solution(int[] lottos, int[] win_nums){
   
      int[] rank={6,6,5,4,3,2,1};
      int cnt=0, zero=0;
      Arrays.sort(win_nums);
      for (int i = 0; i < lottos.length; i++) {
          if(Arrays.binarySearch(win_nums, lottos[i])>-1){
                cnt++;
          }
          else if(lotto[i]==0) zero++;
      }
      int[] answer={rank[cnt+zero],rank[cnt]};
      return answer;
      
}
