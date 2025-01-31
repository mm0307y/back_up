package inheritance_11_18.step2_11_18;
/*
Java에서는 실행 중 타입 정보를 확인하기 위해 instanceof와 클래스의 메타 정보를 제공하는
Class 객체를 사용합니다.
1. instanceof
객체가 특정 클래스나 인터페이스의 인스턴스인지 확일 할 수 있습니다.

2. Class 객체를 통한 타입 확인
Java에서는 모든 클래스가 런타임에 Class 객체로 표현됩니다.
이를 통해 타입을 비교하거나 정보를 얻을 수 있다.

RTTI(Run-Time Type Information)은 Java에서 객체의 런타임 타입에 대한
정보를 얻고 작업을 수행하는 기능을 말합니다.
RTTI는 Java의 다형성을 이해하고 활용하는데 필요한 개념이다.

활용사례
1. 객체 실제 타입 확인
2. 다운 케스팅
3. 타입에 따라 다른 동작 수행

주의 : 서버 성능을 저하시키므로 제한적으로 사용해야 한다.

RTTI의 단점 : 성능저하, 디자인 의존성을 증가시켜 유지보수 저하를 가져온다.
필요할 때만 사용한다.

Spring Framework를 모방하기
가능한 이유는 자바에서 RTTI와 리플렉션을 지원하기 때문에 가능하다.
- RTTI는 기본적으로 자바가 제공하는 컴파일된 클래스 정보를 런타임에 활용하는 방식
- 컴파일 시에 알려진 클래스만 처리할 수 있다.
- 리플렉션을 사용하면 런타임에 동적으로 클래스의 구조(필드나 메서드)를 탐색하거나 수정할 수 있다.
- 프레임워크/라이브러리에서 객체 타입을 기반으로 동적 처리가 가능하다.
*/

class Base{

}

class Drived extends Base{

}

public class InstanceMain_11_19 {
    public static void main(String[] args) {
        //자바에서는 생성부 이름으로 객체가 생성된다. - 선언부의 이름이 아니고
        Base b = new Drived();
        if (b instanceof Drived){
            System.out.println("b is an instance of Drived");
        }
        else {
            System.out.println("b is not an instance of Drived");
        }
        System.out.println(b.getClass().getName());
    }
}
