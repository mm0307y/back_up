package classes_10_17.design_10_31;

//코드 양은 늘어나더라도 복잡도는 낮추는 코드를 작성하자.
//상속이 재사용성을 위한 모법답안이 아니다. - 결합도가 높다. - 의존성이 높다. - 단위테스트 불가
//추상 클래스와 인터페이스를 중심으로 코딩을 전개하는 방식으로 - 프로젝트를 하게(강제) 된다. - Spring Boot
public class WoodDuck_10_31 extends Duck_10_31{
    public WoodDuck_10_31(){
        flyBehavior = new FlyNoWay_10_31();
        quackBehavior = new MuteQuack_11_01();
    }

    @Override
    public void display() {
        System.out.println("I`m a WoodDuck");
    }
}
