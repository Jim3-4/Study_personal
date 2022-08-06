import java.util.*;
 //n=12   -6까지검사       / n=15 - 7까지 검사 / n=16
//(1,12) (2,6) (3,4)    / (1,15) (3,5)     / (1,16) (4)
class Solution {
    public int solution(int n) {
        int answer = 0;
       
        if(n==1 || n==0){
            return n;
        }
        
       HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
            double root=Math.sqrt(n);

            if(n==Math.pow((int)root,2)) {
                answer+=1+n+(int)root;
                return answer;
            }
        
            for(int i=1; i<=n/2; i++){
               
                if(n%i==0){   
                   if(map.containsValue(i) ||map.containsKey(i)) continue;
                   else {
                     map.put(i,n/i);
                     answer+=i+(n/i);
                   }
                  
               } 
            }

        return answer;
    }
}
