package classes_10_17.step1_10_21;

class Some{
    SomeObject_10_21 so = null;
    public Some(){
        
    }

    // 같은 이름의 생성자를 여러개 가진다.(파라미터의 갯수가 다르거나 반드시 타입이 달라야 한다.)
    public Some(SomeObject_10_21 so){
        System.out.println("Some Constructor " + so); //얕은복사 - 하나다.
        this.so = so;
    }
}

public class SomeObject_10_21 {
    //선언부
    //클래스와 클래스 사이에 관계가 있다.
    //아래 코드가 언제 초기화 되는가
    //어떤 생성자가 먼저 출력되나요? 순서
    Some some = new Some(this); //얕은복사와, 깊은복사

    //생성자 - 메서드 활용(선언과 호출 유사 - 다른 점은 리턴이 없다.)
    public SomeObject_10_21(){
        System.out.println("SomeObject Constructor");
    }


    //사용자 정의 메서드
    void methodA(){}

    //메인메서드
    public static void main(String[] args) {
        SomeObject_10_21 so = new SomeObject_10_21(); //디폴트 생성자 호출 - 벰버가 초기화가 일어난다.
        System.out.println("main : " + so);
    }

}
