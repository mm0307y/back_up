package day4_10_11.variable;

public class K5_10_11 {
    // 선언부
    int a;
    int speed;

    //생성자
    public K5_10_11(){
        System.out.println("K5디폴트 생성자 입니다.");
    }

    public void speedUP(){
        speed = speed + 1; // 너(speed)는 지역변수 라 안되고
        a = a + 1; // 나(speed)는 전역변수라 된다.
    }

    // 생성자
    // 사용자정의메소드
    // static 블럭입니다. - 잘 쓰지 않아요
    static {
        // K5가 전시장에서 전신되어 있는 상태입니다.
        int speed = 0;
        System.out.println("static블럭이 호출되었습니다. \n 그러면 main()보다 먼저");
    }////////////////// end of static 블럭

    // 메인메소드
    public static void main(String[] args) {
        System.out.println("main() 호출되었습니다.");
        K5_10_11 K5 = new K5_10_11();
        K5.speedUP();
    }////// end of main
}///////// end of K5
