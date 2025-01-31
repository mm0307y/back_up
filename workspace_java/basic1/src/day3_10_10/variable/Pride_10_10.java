package day3_10_10.variable;
// 그럼 toString메소드는 누가 정의하였나요? - Object
// 자바에서는 제공하는 클래스가 있습니다. - Object
// 모든 클래스의 부모 클래스 입니다. -> 모든 클래스는 원하지 않아도 Object를 상속받고 있다.
// pride클래스 타입을 인스턴스화 하면 부모 클래스인 Object가 제공하는 toString()호출할 수 있다.
public class Pride_10_10 extends Object{
    public  String toString(){
        return "나는 프라이드 자동차 입니다.";
    }

    public static void main(String[] args) {
        // insert here
        // herCar는 인스턴스화에서 선언된 변수 이므로 인스턴스 변수하고 한다.
        // herCar를 이용해서변수나 메소드를 호출할 수 있다.
        // 이 때 호출할 수 있는 변수는 전역변수만 가능합니다.(지역변수는 불가)
        Pride_10_10 herCar = new Pride_10_10();
        // 현재 pride.java소스 파일 안에는 전변이 없어서 호출할 수 없다.
        // 그러나 toString()는 재정의 하였다. 그래서 호출하면 부모클래스(Object)가 제공하는
        // toString() 호출되는게 아니라 pride.java 안에서 구현한 메소드가 호출됩니다.
        // 이 코드에서는 toString()가 구현되어 있어서 주소번지가(@b2c336)가 출력되지 않고
        // 대신에 나는 프라이드 자동차 입니다. 가 대신 출력 됩니다.
        System.out.println(herCar);
        System.out.println(herCar.toString());

    }
}
