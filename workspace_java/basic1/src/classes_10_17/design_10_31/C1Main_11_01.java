package classes_10_17.design_10_31;

//클래스가 세개이면 순환구조로 만든다. - Stack OverFlow
//this는 사용 위치에 따라 다른 타입이면 다른 주소번지를 갖게 되는 것이다.
//UI담당 -> LoginForm.java(View계층) -> LoginDao.java(Back-End) : DB연동(서버)
//UI담당 -> Talk Clinet(actionperformed)
class C1 {
    C1(){
        System.out.println("C1()" + this);
    }

}

public class C1Main_11_01 {
    public C1Main_11_01() {
        System.out.println("C1Main_11_01" + this);
    }

    public static void main(String[] args) {
        //c1의 주소번지와 11번 this의 주소번지가 같다 | 아니다.
        C1Main_11_01 c1 = new C1Main_11_01();
        System.out.println("main : " + c1);
        C1 c2 = new C1();
    }
}
