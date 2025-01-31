package mvc1_11_21;

class A1{
    //나는 A2 클래스의 methodA()를 호출하기 위해서
    //A1 멤버영역에서 A2를 인스턴스화를 할 수 있다. | 없다.
    A2 a2 = new A2();
    void methodA(){
        System.out.println("A1.methodA() 호출");
        a2.methodA();
    }
}

class A2{
    A3 a3 = new A3();
    void methodA() {
        System.out.println("A2 methodA() 호출");
        a3.methodA();
    }
}

class A3{
    void methodA() {
        System.out.println("A3 methodA() 호출 성공");
    }
}

public class Exam1_11_21 {
    public static void main(String[] args) {
        A1 a1 = new A1();
        a1.methodA();
    }
}
