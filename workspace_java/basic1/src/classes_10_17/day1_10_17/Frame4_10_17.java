package classes_10_17.day1_10_17;
// 대주제 - 인스턴스화 설득
import javax.swing.*;
/* 소나타는 자동차이다.
Frame4는 JFrame 이다.
Frame4 is a JFrame
상속은 클래스간의 결합도를 높이는 코드이므로 권장하지 않는다.
독립적인 코드 작성하기 - 왜냐면 단위 테스트와 통합 테스트가 가능하도록

ex) 주문관리와 배송관리는 관계가 있다.
근데 엄무 순서는 주문관리 먼저이고 배송관리는 그 다음이다.
주문관리는 3년차 개발자가 배송관리는 7년차 개발자가 담당했다.
왜 주문관리가 있어야 배송관리를 테스트 할 수 있는 걸까?
주문이 들어와야 배송번호 발번된다.
배송관리를 담당하는 메소드는 파라미터로 주문내역을 받아 온다.*/

//인터페이스나 추상클래스 중심의 코드를 전개하세요.
public class Frame4_10_17 extends JFrame {

    public void intiDisplay(){
        this.setTitle("Frame4");
        this.setSize(500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}