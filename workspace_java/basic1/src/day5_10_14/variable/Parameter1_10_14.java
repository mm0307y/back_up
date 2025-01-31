package day5_10_14.variable;

public class Parameter1_10_14 {
    public A_10_14 methodA(){
        return new A_10_14();
    }

    public static void main(String[] args) {
        Parameter1_10_14 p = new Parameter1_10_14();
        System.out.println(p.methodA()); // A 클래스의 주소번지가 출력된다.
    }
}
