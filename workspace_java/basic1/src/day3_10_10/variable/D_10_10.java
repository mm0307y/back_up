package day3_10_10.variable;

public class D_10_10 {
    // 전역변수 이면서 static 입니다.
    static  int i; // 전역변수 선언하는 자라입니다.
    // non-static변수 선언
    // 변수 j는 전역변수 이고 non-static
    int j = 2;
    public static void main(String[] args) {
        System.out.println(i); // 0
        D_10_10 d = new D_10_10();
        // insert here
        d.j = 3;
        System.out.println(d.j); // 2 -> 3(13번 라인 실행하면)
        // insert here

    }
}
