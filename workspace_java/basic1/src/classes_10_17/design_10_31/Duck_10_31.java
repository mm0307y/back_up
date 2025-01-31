package classes_10_17.design_10_31;

public abstract class Duck_10_31 {
    public FlyBehavior_10_31 flyBehavior;
    public QuackBehavior_11_01 quackBehavior;
    public Duck_10_31() {
        System.out.println("Duck Constructor");
    }

    //왜 인스턴스 변수를 두번 연속해서 써야 했나?
    //myDuck.flyBehavior.fly()
    //구현체 클래스인 MallardDuck, WoodDuck, RubberDuck 는
    //fly() 직접 호출하지 않도록 변경해 본다.
    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public abstract void display(); //추상메서드

    public void swimming(){
        System.out.println("나는 물위에 뜹니다.");
    }
}

/*
추상 클래스 & 인터페이스
추상 클래스와 인터페이스는 모두 단독으로 인스턴스화를 할 수 없다.
* */
