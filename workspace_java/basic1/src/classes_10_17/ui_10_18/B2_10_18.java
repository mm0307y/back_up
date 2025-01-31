package classes_10_17.ui_10_18;

public class B2_10_18 {
    B1_10_18 b1 = null;
    /*B1_10_18 b2 = new B1_10_18(); // 왜냐면 깊은 복사니깐 문제다. - 복제본이 만들어진다.
    여기서는 원본 하나를 원하는 것이다.*/

    public B2_10_18(B1_10_18 b11018) {
        System.out.println("B2 디폴트 생성자 호출");
        this.b1 = b11018;
    }

    public static void main(String[] args) {

    }
}
