package day3_10_10.variable;

public class A_10_10 {
    public String toString(){
        return "나는 A타입의 클래스 입니다.";
    }
    public static void main(String[] args) {
        A_10_10 a = new A_10_10();
        System.out.println(a);
        System.out.println(a.toString());
        a = null;
        System.out.println(a);
        a = new A_10_10();
        System.out.println(a);
        // 타입(a)은 같지만 주소번지(A, 참조형)는 다르다.
    }
}
