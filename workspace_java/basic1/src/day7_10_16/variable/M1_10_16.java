package day7_10_16.variable;

public class M1_10_16 {
    /*
    생성자는 클래스 이름을 적는다.
    생성자는 반환 타입이 없다.
    생성자는 인스턴스화 할 때 호출된다.
    디폴트 생성자는 파라미터가 없는 거라서 안 적으면
    JVM이 대신 처리한다.
    */

    public M1_10_16(){
        System.out.println("M1디폴트 생성자");
        System.out.println(this); // 18번 코드와 같은 주소번지인가? 21번코드와 같은 주소번지인가
    }

    public static void main(String[] args) {
        M1_10_16 m1 = new M1_10_16();
        String s1 = new String("Hello");
        System.out.printf("%s, %s \n", s1, m1);
        m1 = null;
        System.out.println("M1_10_16 : " + m1); // null
        m1 = new M1_10_16();
        m1.toString(); // 예외(Exception - 디버깅, 문제해결)가 발동하면 프로그램이 멈춘다.
    }

}
