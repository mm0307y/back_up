package classes_10_17.design_10_31;

//구현체 클래스의 메서드 이름을 직접 모르더라도 해당 메서드를 호출할 수 있다.
//클래스 간의 결합도를 낮추는 코드를 작성해 본다.
public class Squeak_11_01 implements QuackBehavior_11_01{
    public void quack() {
        System.out.println("삑~삑");
    }
}
