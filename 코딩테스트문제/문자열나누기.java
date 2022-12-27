	public int solution(String s) {
		//첫번째글자는  처음나오니까 넣어준다. 
		char first = s.charAt(0);
		int firstNum = 0;
		int diff = 0;
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			System.out.println("지금 for문 순서 글자는 "+ s.charAt(i));
			
			if (firstNum == diff) {
				result++;
				first = s.charAt(i);
			}
			
			if (s.charAt(i) == first) firstNum++;
			else diff++;
		}
		return result;
	}
