public class Foo {
  public static void main(String args[]) {

    String s = "1000.0";                      // 문자열 정의


    try {
      int i = Integer.parseInt(s) + 1;        // 32비트 정수로 그리고 1을 더하기
      System.out.println(i);
    } catch (NumberFormatException nfe) {
      System.err.println(nfe);
      System.exit(1);
    }

    // 에러: java.lang.NumberFormatException: For input string: "1000.0"

  }
}
