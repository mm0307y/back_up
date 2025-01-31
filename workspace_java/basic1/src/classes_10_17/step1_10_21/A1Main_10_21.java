package classes_10_17.step1_10_21;

class A1 {
    A1Main_10_21 am = null; // 주의 : new하지 말 것 - 반복호출이 되어서 stack memory overflow
    A1(){

    }

    // 생성자 파라미터 자리에 null이 올수 있습니다. 기억하기
    // 참조형 타입을 파라미터로 넘기는 경우 null유무 체크하기
    A1(A1Main_10_21 am){
//        am = new A1Main_10_21();
        if (am == null){
            System.out.println("파라미터로 넘어온 주소번지가 아무것도 가리키지 않는다.");
        }
        else {
            //위치1
            am.m(); //지역변수 안에서 사용된다.
//            this.am = am; //스팟, 18번에서 정상적으로 호출 되었다. 나는 왜 필요한가요? 전역변수 특성을 갖고 있어서 인스턴스화를 해야 사용이 가능하다.
            //위치2
            other();
        }
        // 11번과 12번에 대해 말할 수 있다.
//        am.m();
//        this.am.m();
    }
    void other(){
        this.am.m();
    }
}

public class A1Main_10_21 {
    //파라미터 자리의 null은 타입만 있고 실체가 없다.
    //타입은 A1Main
    A1 a1 = new A1(this);
    void m(){
        System.out.println("m() 호출");
    }

    public static void main(String[] args) {
        new A1Main_10_21();
    }
}
