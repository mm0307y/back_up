package day6_10_15.variable;
/*
관전 포인트
리턴타입 다양한 확인 - int, double, Sting + Sub1 -> this도전 해보자
*/

class Sub1{
    // Deprecated 메시지 출력된다. - 앞으로는 더 이상 지원하지 않는다. API에서 빠질 수 있다.
    // 같은 위치인데 static이 있으면 전역변수(global variable) - 하나다, 공유다
    // 인스턴스를 하고 사용하는 변수가 멤버변수(member variable) 이다.
    int i = 1; // non-static 변수이다. - 멤버변수

    void methodX(){ // 멤버 메서드이다. 왜냐면 인스턴스.methodX()호출 가능하다.
        System.out.println(i);
    } // end of methodX()
} //// end of Sub1

public class Return1Main_10_15 {

    int methodA(){
        return 1; // return 변수명(권장), 상수 싫어요, 변수 좋아요.
    }

    double methodB(){
        return (double) 2; // 2가 아니라 2.0이다.
//        return 2; // double 보다 작은 타입은 자동형 전환이 일어난다. - 합법이다.
//        System.out.println(""); // return 뒤에는 아무것도 못쓴다.
//        return 2L; // if문 안에서도 사용된다.
    }

    String methodC(){
        return "hello";
    }

    Sub1 methodD(){
        return new Sub1();
    }

    Sub1 methodE(){
        Sub1 sub = new Sub1();
        return sub;
    }

    public static void main(String[] args) {
        // insert here
        Return1Main_10_15 m = new Return1Main_10_15();
        System.out.println(m.methodA()); // 1
        System.out.println(m.methodB()); // 2.0
        System.out.println(m.methodC()); // "hello"
        System.out.println(m.methodD()); // 주소번지 값 출력 @1234asdf
        System.out.println(m.methodE()); // 주소번지 값 출력 @4567qwer
        System.out.println("----------------------------------------");

        // sub1 과 sub2의 주소번지는 서로 다르다. | 같다.
        Sub1 sub1 = m.methodD(); // 인스턴스화를 해서 Sub1에 있는 i에 접근한다.
        System.out.println(sub1.i); // 접근한 i를 출력한다.
        System.out.println(sub1);
        System.out.println("----------------------------------------");

        Sub1 sub2 = m.methodE();
        sub2.i = 100;
        System.out.println(sub2.i); // 100
        // 같은 타입이지만 서로 다른 객체라서 똑같이 i를 출력하더라도
        // 어떤 때는 1을 어떤 때는 10을 출력할 수 있다.
        // 다른 사람들의 주문을 구분할수 있고 서로 다른 상태값을 유지하는 것이다.
        System.out.println(sub2);
        System.out.println("----------------------------------------");

        if(sub1.equals(sub2)) System.out.println("주소번지가 같다."); // 조건문(if)에서 실행문이 한줄이면 좌,우 괄호를 생략할 수 있다.
        else System.out.println(sub1+ " 의 주소번지와 " + sub2 + " 다르다."); // 여기가 실행된다.

        if (sub1 == sub2) System.out.println("주소번지가 같다");
        else System.out.println("주소번지가 다르다."); // 여기가 실행된다.
        // 왜냐면 깊은 복사다. 복제본이 만들어졌다.
        // 이렇게 복제본을 쉽게 만들기 위해 우리는 클래스를 선언한다.
    }
}
