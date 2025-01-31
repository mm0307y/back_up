package day2_10_08.variable;

public class Scanner2Hint_10_08 {
    public static void main(String[] args) {
        // 문자열 사이에 더하기 연산자를 사용하면 문자여을 붙여서 출력해줍니다.
        System.out.println(2 + 3); //5
        // int + int = int, String + int = String
        System.out.println("8번 라인 : " + (Integer.parseInt("2") + 3)); //23
        // String + String = String
        System.out.println("2" + "3"); // 23
        System.out.println(Integer.parseInt("2") + Integer.parseInt("3")); // 23
    }
}
