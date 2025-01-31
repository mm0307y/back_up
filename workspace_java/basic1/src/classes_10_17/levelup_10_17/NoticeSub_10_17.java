package classes_10_17.levelup_10_17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeSub_10_17 extends JFrame implements ActionListener {
    JPanel jp_center = new JPanel();
    JPanel jp_south = new JPanel();
    JButton btn_save = new JButton("저장");
    JButton btn_close = new JButton("닫기");
    public NoticeSub_10_17() {
//        initDisplay();
    }

    public void initDisplay(){
        btn_save.addActionListener(this);
        btn_close.addActionListener(this);

        jp_center.setBackground(Color.GREEN);
        jp_south.setLayout(new FlowLayout(FlowLayout.CENTER));
        jp_south.add(btn_save);
        jp_south.add(btn_close);

        this.add("Center", jp_center);
        this.add("South", jp_south);
        this.setSize(400,500);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        Container cont = this.getContentPane();

        if(obj == btn_save){ //너 입력버튼 누른거야?
//            nm.intiDisplay();
            this.setVisible(false);
//            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            NoticeMain_10_17 k = new NoticeMain_10_17();
            k.intiDisplay();
        }
        else if(obj == btn_close) {
            this.dispose();
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

    }

    public static void main(String[] args) {
        NoticeSub_10_17 nn = new NoticeSub_10_17();
        nn.initDisplay();
    }
}