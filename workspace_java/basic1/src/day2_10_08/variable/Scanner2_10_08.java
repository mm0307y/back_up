package day2_10_08.variable;
// 문제풀이
// 답안지를 두 가지로 작성해 봅시다.

import java.util.Scanner;

public class Scanner2_10_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 터미널 (명령프롬프트화면에서, 까만화면)에서 사용자가 값을 읽어올 수 있다.
        System.out.println("0부터 9사이의 숫자를 입력해줘.");
        String input = scanner.next();
        System.out.println("첫번째 입력받은 숫자 : " + input);
        System.out.println("한번 더 0부터 9사이의 숫자를 입력해줘.");
        String second = scanner.next();
        System.out.println("두번째 입력받은 숫자 : " + second);
        System.out.println("두수의 합은 : " + Integer.parseInt(input) + Integer.parseInt(second));
    }
}