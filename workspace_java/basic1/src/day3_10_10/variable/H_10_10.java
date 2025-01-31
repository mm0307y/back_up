package day3_10_10.variable;

public class H_10_10 {

    public static void main(String[] args) {
        // int i = "1";
        // char > byte > short > int > long > float > double
        // boolean
        // 대입 연산자 오른쪽에 더 큰 타입이 왔습니다.
        int i = (int)3.14;
        System.out.println(i); // 3출력
        double d = 3.14;
        System.out.println(d); // 3.14 출력
        // i = d;
        d = i;
        System.out.println(d); // 3.14 -> 14번 라인에서 다시 치환 -> 3.00 출력
    }
}
