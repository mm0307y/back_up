package day2_10_08.variable;
/*
에러에는 두 가지 종류가 있다.
compile time(문법 -> XXX.class파일이 만들어지지 않습니다. - 실행할 수 없음) 에러
run time(실행시) 에러
 */

import java.util.Scanner;
// 사용자가 입력하는 값으 반드시 유효성 검사를 해야 합니다.
public class Scanner2Dab2_10_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 터미널 (명령프롬프트화면에서, 까만화면)에서 사용자가 값을 읽어올 수 있다.
        // 그래서 후에 예외처리 수업에서 자세히 다루어 봅시다.
        System.out.println("0부터 9사이의 숫자를 입력해줘.");
        int i_input = scanner.nextInt();
        System.out.println("첫번째 입력받은 숫자 : " + i_input);
        System.out.println("한번 더 0부터 9사이의 숫자를 입력해줘.");
        int i_second = scanner.nextInt();
        System.out.println("두번째 입력받은 숫자 : " + i_second);
        // insert here
        System.out.println("두수의 합은 : " + (i_input + i_second));
    }
}
