package classes_10_17.design_10_31;

public class MallardDuck_10_31 extends Duck_10_31{
    public MallardDuck_10_31(){
        /*선언부와 생성부가 다르다.
        호출하는 메서드는 fly(()메서드로 동이하.(고무오리, 나무오리)
        3가지 오리 모두 fly()호출할 수 있지만 청둥오리는 날고 있어요 가 출력된다.
        고무오리, 나무오리는 나는 날지 못합니다. 가 출력된다.
        어디 타입으로 날고 있는지와 날지 못하는기자 구별되는 걸까요?
        구현체 클래스를 작성할 때 날 수 있는지 없는지가 결정된다.*/
        flyBehavior = new FlyWithWings_10_31();
        //어떤 구현체 클래스를 선택하느냐는 결국 해당 클래스가 알고 있다.
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("나는 청둥오리 입니다.");
    }
}