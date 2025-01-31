package classes_10_17.ui_10_18;

import javax.swing.*;

public class AddressMain_10_18 {
    //선언만 하였고 참조하는 객체가 없는 상태이다.
    JFrame frame = null;
    AddressMain_10_18() {
        frame = new JFrame();
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    /*원하는 클래스를 찾았다면 가장 먼저 볼 것은 생성자 입니다.
    왜냐하면 생성자의 선택에 따라서  추가적인 메서도 호출이나 설정, 초기화 등을 생략가능하기 때문이다.*/
    AddressMain_10_18(String title) {
        frame = new JFrame(title); // 여기를 본다.
        frame.setSize(300,600);
        frame.setVisible(true);
    }
    public static void main(String[] args) {

    }
}
