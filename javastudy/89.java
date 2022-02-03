package twoInterface;

public class MultiCatchExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		
			String data1=args[0];
			String data2=args[1];
			int value1=Integer.parseInt(data1);
			int value2=Integer.parseInt(data2);
			int result=value1+value2;
			System.out.println(result);
		}catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("실행 매개값이 수가 부족하거나 숫자로 변환 ㄴㄴ");
		}catch(Exception e) {
			System.out.println("알수없는 예외발생 ");
		}finally {
			System.out.println("다시 실행하세요");
		}
	}

}
