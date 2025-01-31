package classes_10_17.design_10_31;

public class Quack implements QuackBehavior_11_01{
    @Override
    public void quack(){ //청둥오리 일때
        System.out.println("꽥~꽥");
    }

}

/*메서드 오버로딩 & 메서드 오버라이딩
전체조건 - 같은 이름일때만 가능하고 이름이 다르면 고려대상이 아니다.
오버로딩 - 파라미터의 갯수나 타입이 달라야 한다.

오버라이딩 - 선언부가 같아야 한다. 즉, 리턴타입이 같고 파라미터가 같아야 한다.
반드시 구현체 클래스 관계 일때만 따진다.
인터페이스 타입 변수명 = new 구현체 클래스()
flyBehavior = new FlyWithWing(), flyBehavior = new FlyNoWay();

추상클래스 타입 변수명 = new 구현체 클래스()
Duck myDuck = new MallardDuck()
Duck myDuck = new RubberDuck()
Duck myDuck = new WoodDuck() */
