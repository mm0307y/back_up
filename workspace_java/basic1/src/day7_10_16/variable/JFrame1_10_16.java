package day7_10_16.variable;

import javax.swing.*;

public class JFrame1_10_16 {
    JFrame frame = null;

    public void initDisplay(){
        frame = new JFrame();
        frame.setSize(400,500);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame1_10_16 f1 = new JFrame1_10_16();
        f1.initDisplay();
    }
}
