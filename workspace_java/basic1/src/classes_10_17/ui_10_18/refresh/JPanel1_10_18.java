package classes_10_17.ui_10_18.refresh;

import javax.swing.*;
import java.awt.*;

// JPanel은 JFrame처럼 윈도우창을 제공하지 않습니다.
public class JPanel1_10_18 extends JPanel {

    public JPanel1_10_18() {
        initDisplay();
    }

    public void initDisplay(){
        this.setBackground(Color.green);
        this.setSize(400,300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JPanel1_10_18();
    }
}
