package classes_10_17.day5_10_28;
/*
인스턴스화에서 선언부와 생성부의 이름이 다른 경우에 대해 알아본다.
1) 부모에서는 없는데 자손에는 있는 메서드를 추가하였다. - n메서드 이다.
2) 테스트 시나리오
Parent p1 = new Parent(); - 기본이다.
Parent p2 = new Child(); - 부모타입과 생성자 타입이 다른 경우 - 다형성이 가능하다.
자바의 특징 - 재사용성과 이식성
p1.n(); 가능한가?
p2.n(); 가능한가?
관찰 포인트
부모타입에너느 없는 메서드를 과연 자손타입에서 호출할 수 있나?
자손타입으로 부모에도 있고 자손에서도 있는 메서드를 호출한다면
과연 어떤 메서드가 호출 될까요?
*/

class Parent4{
   void m(){
       System.out.println("Parent4.m()");
   }
}

class Child4 extends Parent4{
    Child4(){
        System.out.println("17, Child4");
    }
    @Override
    void m(){
        System.out.println("Child4.m()");
    }
    void n(){
        System.out.println("Child4.n()");
    }
}

public class PC4Main_10_28 {
    public static void main(String[] args) {
        Parent4 p = new Parent4();
        p.m();
        //부모타입으로 선언된 변수로 자손클래스의 메서드 호출은 불가합니다.
        //p.n();
        //상속 받을 때는 자손클래스를 상속 받는 것이 더 누릴수 있는 벼눗와 메서드가 많다.
        Child4 c = new Child4();
        c.m();
        c.n();
        //선언부 타입과 생성부의 타입이 다른경우 - 다형성을 누릴수 있다.
        //객체생성시 주의사항 - 사이드 이펙트(Spring 프레임 웤에서는 대신 관리해준다.)를 피하는 코드 작성하기.
        //구현체클래스 변수명 = new 구현체 클래스();
        //인터페이스 변수명 = new 구현체 클래스();
        //추상클래스 변수명 = new 구현제 클래스();
        Parent4 p1 = new Child4();
        p1.m();
//        p1.n(); //실제로 생성된 클래스는 Child4 이지만 타입이 부모타입이면 자손에 선언된 메서드는 호출불가
        //API에 대한  활용능력을 키운다.
    }
}
/*
자손클래스이 생성자가 호출될 때 먼저 부모클래스 생성자가 먼저 호출 됩니다.
디폴트 생성자는 파라미터를 따로 정해주지 않아도 되니까 자동으로 제공할 수 있다.
파라미터가 있는 생성자를 호출하더라도 부모의 디폴트 생성자가 호출되었다.
*/