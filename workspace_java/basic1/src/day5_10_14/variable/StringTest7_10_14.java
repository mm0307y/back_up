package day5_10_14.variable;
class Z{
    int i;
}

class Cat{
    int a;
}
public class StringTest7_10_14 {
        public static void main(String[] args) {
            // 외부 클래스의 변수를 사용하려면 인스턴스화 합니다.
            Z z = new Z();
            System.out.println(z); // 주소번지가 출력됩니다. @abcd1234
            // Z클래스는 주소번지가 출력되는데(일반적이다.)
            // 반해서 String은 클래스 임에도 불구하고 주소번지가 아니라
            // 문자열 값이 출력됩니다.(예외적이다.)
            String s = new String("안녕하세요.");
            System.out.println(s);
            Cat c = new Cat();
            System.out.println(c); // 주소번지가 출력된다.

    }
}
