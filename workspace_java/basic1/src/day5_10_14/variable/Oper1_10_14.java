package day5_10_14.variable;

public class Oper1_10_14 {
    public static void main(String[] args) {
        Oper1_10_14 o1 = new Oper1_10_14();
        System.out.println(o1); // 주소번지가 출력된다.
        int i = 1;
        int j = i + 2; // 1 + 2 = 3이 j변수에 초기화 됩니다.
        j += 2; // j = j + 2, += 먼저 앞에 변수와 뒤에 2를 더하고 대입하세요.

        //insert here - 가 출력된다.
        System.out.println(j); // 5 출력
    }
}
