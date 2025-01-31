package day7_10_16.variable;

import javax.swing.*;

// JFrame2_10_16클래스는 JFrame클래스를 상속받아서 만든 클래스이다.
public class JFrame2_10_16 extends JFrame {

    public void initDisplay(){
        this.setSize(400,500);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame2_10_16 f1 = new JFrame2_10_16();
        f1.initDisplay();
    }
}
