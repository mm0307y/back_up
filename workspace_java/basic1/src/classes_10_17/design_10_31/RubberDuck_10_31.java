package classes_10_17.design_10_31;

public class RubberDuck_10_31 extends Duck_10_31{
    public RubberDuck_10_31(){
        flyBehavior = new FlyNoWay_10_31();
        quackBehavior = new Squeak_11_01();
    }

    @Override
    public void display() {
        System.out.println("I`m a RubberDuck");

    }
}
