package day2_10_08.variable;

import java.util.Scanner;

public class Scanner1_10_08 {
    // 사용자가 정의하는 메소드 입니다.
    // 제공되는 메소드가 아니고 개발자가 같은 이름의 메소드를 선언하였다.
    String next(){
        return "안녕";
    }

    int nextInt(){
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner1_10_08 scanner1 = new Scanner1_10_08();
//        String a = scanner1.next();
        int a = scanner1.nextInt();
        System.out.println("안녕"); // 문자열 상수를 사용했다. 변수를 사용하지 않았습니다. 비추천
        System.out.println(a); // 안녕 출력 -> 1출력 됨
        System.out.println(scanner1.next()); // 안녕
        System.out.println(scanner1.nextInt());

    }
}
