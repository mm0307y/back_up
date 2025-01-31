package classes_10_17.design_10_31;
//추상클래스와 인터페이스 역할 - 클래스 설계 - 코드를 읽어내는 능력을 키워야 살아남는다.
//자동화, 효율성(재사용성과 이식성) - OOP사상 - 자바를 자바답게 코딩하기
//자바를 가지고 절차지향적인 코딩을 전개하는..
//인스턴스화와 null

class B1{
    int i = 1;

}

public class B1Main_11_01 {
    public B1Main_11_01(B1 b1){
        //main메서드 안에서 생성된 객체의 주소번지를 다른 생성자에서
        //사용할 수 있다. - 원본을 파라미터를 받는 것.
        System.out.println("B1Main_11_01(B1) - " + b1); //원본이다. 복사본(깊은복사)이 아니다.
        b1.i =3;
    }
    public static void main(String[] args) {
        //insert here i를 2로 변경해주세요.
        //아무것도 없다. 비어있다.-> 아무것도 참조 하지 않는다. -> 객체가 아닌거다.
        //NullPointerException를 경계해야 한다.
        B1 b1 = null; //선언부 - 객체(참조형 - 주소번지가 있는)만 해당된다.
        //b1.i=2;
        b1 = new B1(); //생성부
        b1.i = 2;
        System.out.println(b1.i); //2
        System.out.println(b1);
        //main메서드 안에서 선언된 b1는 지역변수인데 이것을 다른 생성자나
        //다른 메서드에서 사용하고 싶다면 파라미터로 넘겨서 사용할 것.
        System.out.println(b1.i); //2
        B1Main_11_01 bm = new B1Main_11_01(b1);
        System.out.println("main()B1 - " + b1);
        System.out.println(b1.i); //3
    }
}
