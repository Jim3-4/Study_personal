import java.util.Arrays;

public class Solution {
    public static String solution(String my_string) {
        String answer = "";

        char[] arr= my_string.toLowerCase().toCharArray();
       Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j =0; j < i; j++) {
				if(arr[i]<arr[j]) {
					arr[j]=arr[i];
				}
			}
		}
       answer=new String(arr);
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
		solution("Bcad");
		solution("heLLo");
		solution("Python");
	}
}
