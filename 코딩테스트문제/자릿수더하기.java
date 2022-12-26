 public static int solution(int n) {
	        int answer = 0;
	        String str=new String(String.valueOf(n));
	        for (int i = 0; i < str.length(); i++) {
				answer+=Integer.parseInt(str.substring(i, i+1));
			}
	        System.out.println(answer);
	        return answer;
	    }
