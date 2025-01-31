package classes_10_17.design_10_31;
class D1{
    void methodA(D1Main_11_01 dm){
        System.out.println("methodA - " + dm);
    }
}

public class D1Main_11_01 {
    void m(int i){ //call by value - 초심자

    }

    void methodB(D1 d){ //call by reference - 중급자
        //23번 처럼 파라미터 자리에 직접 new 할 수도 있다. 이러면 깊은 복사가 된다. 2개가 만들어진다. 타입은 같지만 다른 객체가 만들어진다.
        System.out.println("1" + this); //d1, d2
    }

    public static void main(String[] args) {
        D1Main_11_01 d1 = new D1Main_11_01();
        System.out.println("2" + d1);
        D1 d2 = new D1();
//        d1.methodB(d2); //만들어진 걸 넘긴다.
        d1.methodB(new D1()); //객체는 다르다. 새로 만들어서 넘긴다.
        //다른 클래스의 main메서드 안에서 생성된 지변이더라도 다른 클래스의
        //다른 메서드에서 사용할 수 있도록 나는 코딩할 수 있다.
        d2.methodA(d1);
    }
}
