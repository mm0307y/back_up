package day5_10_14.variable;

public class StringTest2_10_14 {
    public static void main(String[] args) {
        String s1 = "Hello";
//        s1 = s1 + " World";
        System.out.println(s1 + " World");
        System.out.println(s1); // Hello만 기억하고 있습니다.
        String s2 = "haha";
        s2.replace('h', 'j'); // 대입연산자로 치환을 하지 않았기 때문에 haha가 출력된다. 즉, String은 불변 객체이다.
        System.out.println(s2); // haha
        s2 = s2.replace('h', 'j');
        System.out.println(s2); // jaja
    }
}
/*
String은 연속된 문자열을 표현하는 클래스형 입니다.
클래스는 언제나 참조형 입니다.
연속된 문자(char, Character)를 저장하는 메모리를 할당합니다.
위 데이터를 처리할 수 있는 각종 메서드를 지원한다.(equals)
StringTest1에서 한 이야기이다.
----------------------------------------------------------
Java의 String은 immutable이다. - 불변 객체
: 변경이 불가하다. 원본이 안 바뀐다.

생각해 볼 문제
select 문 처럼 여러 줄을 여러 단어를 길게 쓸 때 String을 쓰면
메모리 누수가 생기는 건 아닌가?
*/