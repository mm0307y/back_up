package day4_10_11.variable;

public class Casting1_10_11 {
    public static void main(String[] args) {
        int i = 1; // 정수형 - 1, 5, 30
        double pi = 3.14; // 실수형 - 몸무게 70.54, 5.4
        // pi는 실수형을 담는 변수명이라서 정수를 담는 변수 i에 3.14를
        // 담을 수 없다. 그런데 꼭 그헐게 하고 싶으면 casting연산자를 사용한다.
        // casting연산자를 형전환 연산자라고 합니다.
        // i = pi; // 문법 오류다. 왜냐면 대입연산자 오른쪽에 왼쪽보닫 더 큰타입이 와서
        // 문제를 제기했으니 해결 방법도 알아 보자 -> 형전환 연산자를 사용하면 됩니다.
        i = (int)pi;
        // int(정수형) < float(실수형) < double(실수형)
        // 대입연산자 기준으로 오른쪽에 왼쪽보다 더 큰 타입이 오면 안된다.
        // 강제 형전환 연산자를 사용하면 문제를 해결할 수 있다.
        i = (int)5.1;
        System.out.println(i); // 1 -> 3.14 -> 0.14안돼 -> 3
    }
}
