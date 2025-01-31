package classes_10_17.day6_11_14;

class A1 {
    //생성자에는 리턴타입이 없다. 클래스 이름이 온다.
    //파라미터가 없는 생성자를 디폴트(기본 값) 생성자라 한다.
    A1 am = new A1();

    A1() {
        System.out.println("A1");
    }

    //생성자 파라미터 자리 name은 언제 초기화가 되는 건가요?
    //name은 지변이다. - 인스턴스화와 관련이 없다.
    //멤버변수는 인스턴화와 관련이 있다. (중요)
    A1(String name) {
        System.out.println("파라미터가 있는 생성자 - " + name);
    }

    //파라미터 자리는 사용자로 부터 입력 받은 값을 담는 자리이다. -UI/UX - 소통시작
    A1(String name, int age){
        this("강감찬");
        System.out.println("파라미터가 있는 생성자 이름 - " + name + "나이 : " + age);
    }
}

public class A1Main_11_14 {
    public static void main(String[] args) {
        A1 a1 = new A1("이성계",50);
    }
}

