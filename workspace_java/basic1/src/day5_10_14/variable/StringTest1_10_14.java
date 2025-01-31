package day5_10_14.variable;

public class StringTest1_10_14 {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = s1;
        String s3 = new String("Hello");
        String s4 = new String("Hello");
        System.out.println(s1 == s2); // true
        System.out.println(s3 == s4); // false
        // s1이 가리키는 "Hello" 문자열과 s2가 가리키는 "Hello" 문자열이
        // 같니? -> 응 같아 -> true 가 출력된다.
        System.out.println(s1.equals(s2)); // 문자열 값이 같은지 물어본다. true 출력
        System.out.println(s3.equals(s4)); // 문자열 값이 같은지 물어본다. true 출력
        System.out.println(s2.equals(s4)); // true 출력
        System.out.println(s2 == s4); // false - s2의 주소번지와 s4의 주소번지가 같니?
        // s1과 s2의 주소번지는 같다.
        System.out.println(s1 == s4); // false
        // String 객체를 만들때 new 를 사용하지 않으면 (유일하게 원시형처럼 초기화 가능)
        // 기존에 같은 문자열이 메모리에 있는지 없는지 체크하고
        // 만일 있다면 새로운 문자열을 생성하는 것이 아니라 기존에
        // 주소번지를 갖는다.(하나를 공유한다. - 얕은 복사이다.)
        System.out.println(s1 == s2); // true

        /*
        위 예제에서 5번 코드는 s1에 문자 Hello를 담고 있고 s2(6번 코드)는 s1을 대입했기 때문에 문자열인 Hello 값을 갖는다. (9번 코드)
        하지만 7, 8번 코드는 새롭게 정의했기 때문에 값은 문자열은 같으나 담고있는 주소번지는 다르다. 그래서 10번 코드에서 false 가 나온다.

        equals()도 내부적으로는 == 연산자를 사용해 주소를 비교하는 것과 다름이 없다.
        13번 코드는 s1.equals은 문자열 Hello가 같은지 물어보는 코드이기 때문에 13번 ~ 15번까지 코드를 호출하면 ture가 나온다.
        16번 코드를 보면 s2과 s4가 같은 지를 물어보는 코드이다. 이때 무엇이 같은지 물어보는지 확인해야 한다. 16번 코드에서는 주소 번지가
        같은지 물어보는 것이기 때문에 호출을 하게 되면 false가 나온다.
        */
    }
}
