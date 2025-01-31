package classes_10_17.day5_10_28;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameMain_10_28 extends JFrame implements ActionListener {
    JDialogMain_10_28 jdmain = new JDialogMain_10_28(this);
    JPanel jp_north = new JPanel();
    JButton btn_ins = new JButton("입력");
    JButton btn_upd = new JButton("수정");
    JButton btn_det = new JButton("상세보기");
    public JFrameMain_10_28() {
        initDisplay();
    }

    public void initDisplay() {
        btn_ins.addActionListener(this);
        btn_upd.addActionListener(this);
        btn_det.addActionListener(this);
        //JPanel은 디폴트 레이아웃이 FlowLayout 이다.
//        jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
        jp_north.add(btn_ins);
        jp_north.add(btn_upd);
        jp_north.add(btn_det);
        this.add("North", jp_north);
        this.setSize(500,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFrameMain_10_28.setDefaultLookAndFeelDecorated(true);
        new JFrameMain_10_28();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        //너 입력버튼 누른거야?
        if (obj == btn_ins) {
            jdmain.set(btn_ins.getText(),true,true);
        }
        else if (obj == btn_upd) { //수정하고 싶어?
            jdmain.set(btn_upd.getText(), true, true);
        }
        else if (obj == btn_det) { //상세보기 할꺼야?
            jdmain.set(btn_det.getText(),true,false);
        }
        else if (obj == jdmain.jb_close){
            jdmain.setVisible(false);
        }

    }
}
