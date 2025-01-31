package day4_10_11.variable;
/*
3개의 변수 중에서 name 앞에만 static를 붙였다.
그랬더니 나이, 주소는 모두 다른 값을 가지고 있는데
static가 추가된 변수 name은  m1, m2, m3가 서로 다른 주소번지를 갖고 있음에도
name만 같은 값(Tiger)로 출력되었다.
왜?
하나를 바구니가 모두 바뀌었다.??
age나 address는 그렇지 않았다.
*/
class Member_10_11{
    int age; // 회원의 나이를 담을 변수 선언
    static String name; // 회원의 이름을 담을 변수 선언 - 문자열만 된다.
    String address; // 회원 주소를 담을 변수 선언
}

public class MemberMain_10_11 {
    public static void main(String[] args) {
        Member_10_11 m1 = new Member_10_11();
        m1.age = 20;
        m1.name = "John";
        m1.address = "서울시 금천구 가산동";
        
        Member_10_11 m2 = new Member_10_11();
        m2.age = 30;
        m2.name = "scott";
        m2.address = "서울시 마포구 공덕동";
        
        Member_10_11 m3 = new Member_10_11();
        m3.age = 40;
        m3.name = "Tiger";
        m3.address = "서울시 영등포구 당산동";

        System.out.println(m1.age + " | " + m1.name + " | " + m1.address);
        System.out.println(m2.age + " | " + m2.name + " | " + m2.address);
        System.out.println(m3.age + " | " + m3.name + " | " + m3.address);
    }
}
