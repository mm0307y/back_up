package classes_10_17.levelup_10_17;

import javax.swing.*;

public class A1_10_17 {
    /* 파라미터 자리에 객체가 올 수 있다 - 점검
    파라미터자리는 지역변수 성격을 가진다.
    그럼 언제 생성이 되나요? - methodA를 호출할 때 객체가 주입된다.
    메서드 뿐 아니라 생성자도 이런 방식으로 객체를 주입 받습니다. 그래서 중요하다. */
    public void methodA(JFrame frame) {
        System.out.println("methodA");
        System.out.println(frame); // 13번에서 파라미터를 객체를 넘겨 받았다.
        // null이 아닙니다.
        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        A1_10_17 a = new A1_10_17();
        JFrame frame = new JFrame();
        a.methodA(frame);
    }
}
