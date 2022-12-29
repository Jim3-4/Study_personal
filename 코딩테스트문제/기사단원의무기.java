class Solution {
    	public static  int solution(int number, int limit, int power) {
		int answer = 0;

		for (int i = 1; i <= number; i++) {   	
			//약수세주는것을 숫자마다 초기화 해줘야 하니까 
			int count=0;
			for (int j = 1; j *j<=i; j++) {
				if(j*j==i) { 
					count++;
				} else if(i%j==0){
					count+=2;
				}

			}//for-j
			//i문이 끝나기 전에 answer에 해당값을 더해준다. 
			answer+= count>limit? power: count;
		} //for-i
		System.out.println(answer);
		return answer;
	}
}
