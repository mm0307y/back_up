package classes_10_17.ui_10_18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XxxSub_10_18 extends JDialog implements ActionListener {
    // 선언부
    // 남쪽에 붙일 버튼과 중앙에 들어올 입력폼을 구분하는 선으로 활용한다.
    JScrollPane jsp = new JScrollPane();
    JPanel jp_south = new JPanel();
    JButton btn_save = new JButton("저장");
    JButton btn_close = new JButton("닫기");
    XxxMain_10_18 xxxMain1018 = null;

    // 생성자 - 리턴타입이 있으면 생성자가 아니라 메소드 취급 받는다.
    public XxxSub_10_18(XxxMain_10_18 xxxMain1018){
        this.xxxMain1018 = xxxMain1018;
        initDisplay();
    }

    // 화면처리부
    public void initDisplay(){
        btn_save.addActionListener(this);
        btn_close.addActionListener(this);
        jp_south.setLayout(new FlowLayout(FlowLayout.CENTER));
        jp_south.add(btn_save);
        jp_south.add(btn_close);

        this.add("South", jp_south);
        this.add("Center", jsp);
        this.setSize(400,500);
        this.setVisible(false);

    }

    // 메인메서드 쓰면 안된다. (학습목표와 달라지기 때문에)
    public static void main(String[] args) {
//        new XxxSub_10_18(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        /*공지사항 글을 작성한 후 저장 버튼 누르면 DB에 저장하고
        현재 창은 닫고 부모창의 전체조회가 처리되도록 한다.
        왜냐하면 새로운 글이 입력되었으니까 추가된 글까지 출력하기*/
        if (obj == btn_save) {
            xxxMain1018.xxxList();
            this.dispose();
        }
        else if (obj == btn_close) {
            this.dispose();
        }
    }
}
