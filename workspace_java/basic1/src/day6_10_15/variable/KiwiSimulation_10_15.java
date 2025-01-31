package day6_10_15.variable;

import java.awt.event.ActionListener;

public class KiwiSimulation_10_15 {
    public static void main(String[] args) {
        KiwiLogin_10_15 kl = new KiwiLogin_10_15();
        kl.frame.setTitle("외부에서 호출한 화면");
        kl.frame.setSize(500,500);
        kl.frame.setVisible(true);
//        ActionListener kl = new KiwiLogin_10_15();
        // 부모타입에 자손클래스에 구현된 동일한 메서드가 없어서
        kl.initDisplay();
    }
}
