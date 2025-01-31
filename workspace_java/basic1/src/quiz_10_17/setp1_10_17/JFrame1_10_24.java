package quiz_10_17.setp1_10_17;

import javax.swing.*;

public class JFrame1_10_24 extends JFrame {
    JFrame jf = new JFrame();
    JFrame1_10_24() {
        initDisplay();
    }
    public void initDisplay(){
        System.out.println(this);
        System.out.println(jf);
        this.setSize(500, 500);
        this.setVisible(true);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new JFrame1_10_24();
    }
}
