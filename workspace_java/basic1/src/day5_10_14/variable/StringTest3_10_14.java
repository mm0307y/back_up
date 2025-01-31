package day5_10_14.variable;

public class StringTest3_10_14 {
    public static void main(String[] args) {
        // String은 클래스 중에 유일하게 new를 사용하지 않고도
        // 객체를 만들 수 있다.
        String s1 = "Hello";
        String s2 = "Hello";
        System.out.println(s1 == s2); // false
        System.out.println(s1.equals(s2)); // false
    }
}
