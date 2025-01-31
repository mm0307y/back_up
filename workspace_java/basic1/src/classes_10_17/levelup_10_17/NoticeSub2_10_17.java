package classes_10_17.levelup_10_17;

import javax.swing.*;
import java.awt.*;

public class NoticeSub2_10_17 {
    JFrame frame = new JFrame();
    JPanel jp_center = new JPanel();
    JPanel jp_south = new JPanel();
    JButton btn_save = new JButton("저장");
    JButton btn_close = new JButton("닫기");

    public NoticeSub2_10_17() {
        initDisplay();

    }

    public void initDisplay(){
        jp_center.setBackground(Color.GREEN);
        jp_south.setLayout(new FlowLayout(FlowLayout.CENTER));
        jp_south.add(btn_save);
        jp_south.add(btn_close);
        frame.add("Center", jp_center);
        frame.add("South", jp_south);
        frame.setSize(400,500);
        frame.setVisible(false);
    }

    public static void main(String[] args) {
        NoticeSub2_10_17 nn = new NoticeSub2_10_17();
        nn.initDisplay();
    }
}