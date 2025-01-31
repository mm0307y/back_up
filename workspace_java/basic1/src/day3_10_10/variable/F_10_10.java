package day3_10_10.variable;

public class F_10_10 {
    int x = 1;
    public static void main(String[] args) {
        F_10_10 f = new F_10_10();
        // 같은 변수에 대해서 초기화를 여러번 할 수 있다.
        // 변수는 한번에 하나만 담을 수 있다.
        // 전역변수는 인스턴스 변수, 변수명으로 호출이 가능하다.
        // 전역변수는 인스터스 변수, 변수명으로 초기화를 다시할 수 도 있다.
        f.x= 10;
        System.out.println(f.x); // 1 -> 10
        f.x = 20;
        System.out.println(f.x); // 1 -> 10 -> 20

    }
}
