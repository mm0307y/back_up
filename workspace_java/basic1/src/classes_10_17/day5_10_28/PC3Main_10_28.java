package classes_10_17.day5_10_28;

class Parent3{
    Parent3(){
        System.out.println("5, Parent3");
    }
    Parent3(String str){
        System.out.println("8, Parent3(Stirng)");
    }
    void m(){
        System.out.println("11, Parent3.m3()");
    }
}

class Child3 extends Parent3{
    Child3(String str){
        System.out.println("17, Child3");
    }
    @Override
    void m(){
        System.out.println("21, Child3.m()");
    }
}

public class PC3Main_10_28 {
    public static void main(String[] args) {
        Parent3 p1 = new Parent3();
        p1 = new Child3("28, p3");
        p1.m(); //28번 라인이 있다면 Child메서드가 호출된다.
//        Child3 c2 = new Child3("Hello");
        //자바에서는 생성부의 이름으로 객체가 생성되므로
        //p3가 Parent3타입 이더라도 자손의 메서드가 호출된다.
        //이 때 부모의 m메서드는 쉐도우 메서드가 된다.
        Parent3 p3 = new Child3("34, hello");
        p3.m();
    }
}
/*
자손클래스이 생성자가 호출될 때 먼저 부모클래스 생성자가 먼저 호출 됩니다.
디폴트 생성자는 파라미터를 따로 정해주지 않아도 되니까 자동으로 제공할 수 있다.
파라미터가 있는 생성자를 호출하더라도 부모의 디폴트 생성자가 호출되었다.
*/