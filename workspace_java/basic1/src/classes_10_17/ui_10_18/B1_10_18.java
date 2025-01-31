package classes_10_17.ui_10_18;

public class B1_10_18 {
    // B2_10_18 클래스에서 파라미터 B1_10_18을 갖는 생성자가 없다.
    // 그래서 에러 입니다.
    B2_10_18 b2 = new B2_10_18(this); // this는 B1_10_18 타입입니다.

    public B1_10_18(){
        System.out.println("B1 디폴트 생성자 호출");
    };

    public static void main(String[] args) {
        new B1_10_18();
    }
}
