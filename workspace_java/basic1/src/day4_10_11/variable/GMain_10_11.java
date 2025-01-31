package day4_10_11.variable;
class G_10_11 {
    // 선언부 - 변수를 선언하였다. - 위치 -> 여기에 선언하면 전변이다.
    int i; // 전역변수

    static int j; // 여기도 전역변수를 선언하는 위치 이다.
    // G클래스 좌중괄호 우중괄호 안에서는 어디서든 접근할 수 있는 변수이다.

    void methodA(){
        // 변수 i는 전역변수 이므로 G클래스 내부 어디든지 호출이 가능합니다.
        System.out.println(i); // 0
    }
}
// 12 -> 14 -> 5(G_10_11.class) -> 7(0을 출력한다.) -> 8(methodA 끝난다.) -> 나를 호출한 곳으로 이동 -> 16 -> 17
public class GMain_10_11 {

    public static void main(String[] args) {
        // insert here
        G_10_11 g = new G_10_11(); // 인스턴스화이다. - 이 문장을 JVM이 실행하면 heap메모리에 상주한다.
//        System.out.println(g.i);
        g.methodA();
        System.out.println(g.j = 1);
    }
}
