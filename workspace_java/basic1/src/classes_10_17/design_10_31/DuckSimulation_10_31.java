package classes_10_17.design_10_31;


public class DuckSimulation_10_31 {
    public static void main(String[] args) {
        Duck_10_31 herDuck = new RubberDuck_10_31();
        herDuck.performFly(); //메서드 이름이 같다.
        herDuck.performQuack();

        Duck_10_31 himDuck = new MallardDuck_10_31();
        himDuck.performFly(); //메서드 이름이 같다.
        himDuck.performQuack();

        Duck_10_31 myDuck = new WoodDuck_10_31();
        myDuck.performFly(); //메서드 이름이 같다.
        myDuck.performQuack();
        //그런데 결과는 달랐다. - 다형성
    }
}
