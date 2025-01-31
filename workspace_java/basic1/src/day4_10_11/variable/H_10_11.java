package day4_10_11.variable;

public class H_10_11 {
    // 전역변수 == 멤버변수
    int i = 1; // 전역변수(global variable(member variable))

    public static void main(String[] args) {
        // 인스턴스화를 3번 하였으므로 H타입의 클래스가 3개 생성되었다.
        // 3개의 클래스(객체)는 heap메모리에 상주한다.
        H_10_11 h1 = new H_10_11();
        // 전역변수는 인스턴스 변수에 따라서 서로 다른 값을 초기화 할 수 있다.
        h1.i = 2;
        H_10_11 h2 = new H_10_11();
        h2.i = 3;
        H_10_11 h3 = new H_10_11();
        h3.i = 4;
        System.out.println(h1 + "," + h1.i); // 2
        System.out.println(h2 + "," + h2.i); // 3
        System.out.println(h3 + "," + h3.i); // 4
    }
}
