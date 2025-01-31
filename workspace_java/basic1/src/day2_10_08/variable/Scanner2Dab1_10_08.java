package day2_10_08.variable;

import java.util.Scanner;
// 첫번째 답안지와 두번째 답안지 중에 어떤 것이 더 좋은거야?
// -> 코드의 양은 늘어나더라도 코드의 복잡도는 증가되지 않도록 작성해 보세요.
public class Scanner2Dab1_10_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 터미널 (명령프롬프트화면에서, 까만화면)에서 사용자가 값을 읽어올 수 있다.
        System.out.println("0부터 9사이의 숫자를 입력해줘.");
        String input = scanner.next();
        System.out.println("첫번째 입력받은 숫자 : " + input);
        System.out.println("한번 더 0부터 9사이의 숫자를 입력해줘.");
        String second = scanner.next();
        System.out.println("두번째 입력받은 숫자 : " + second);
        // insert here
        int i_input = Integer.parseInt(input);
        int i_second = Integer.parseInt(second);
        System.out.println("두수의 합은 : " + input + second);
        System.out.println("두수의 합은 : " + (i_input + i_second));
    }
}
