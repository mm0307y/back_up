package classes_10_17.design_10_31;

/*인터페이스가 갖는 메서드는 모두 추상메서드 이다.
그러나 추상클래스는 일반 메서드도 있고 추상 메서드도 있다.
그래서 abstract를 생략할 수 없다.
인터페이스가 추상 클래스보다 더 추상적이다. - 생성자도 못 갖는다.(인터페이스)
인터페이스는 반드시 구현체 클래스를 가져야 한다. - 기능을 처리하려면*/
public interface QuackBehavior_11_01 {
    public void quack();
}
