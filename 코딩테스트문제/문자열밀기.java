class Solution {
	 
    public int solution(String A, String B) {
        int answer = -1;
        String copyA = "";
        String tmp = "";
        if(A.equals(B)){
            answer = 0;
        }else {
            for(int i=0; i<A.length(); i++) {
                tmp = A.substring(A.length() - 1);
                copyA = tmp + A.substring(0,A.length() - 1);
                A = copyA;

                if(A.equals(B)){
                    System.out.println(A);
                    answer = i + 1;
                }
            }
        }
        return answer;
    }
}
