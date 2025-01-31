package classes_10_17.levelup_10_17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeMain_10_17 extends JFrame implements ActionListener {
    /* NoticeMain에서 입력버튼을 누르면 actionPerformed메서드가 호출되게 하고
    actionPerformed에서 if문으로 입력버튼이 클릭되었을때
    ns.setTitle(눌려진 버튼에서 라벨을 읽어서 출력되도록 한다.)*/

    NoticeSub_10_17 ns = new NoticeSub_10_17();

    /* JPanel은 단독으로 창을 출력할 수 없지만 JFrame안에
    필요한 버튼들을 독립적인 레이아웃으로 배치할 수 있는 속지 역할이다. */
    //    JPanel jp_center = new JPanel();
    JPanel jp_south = new JPanel();
    JPanel jp_north = new JPanel();
    JButton btn_ins = new JButton("입력");
    JButton btn_upd = new JButton("수정");
    JButton btn_det = new JButton("상세보기");
    JButton btn_del = new JButton("삭제");
    JTextField jtf = new JTextField(30);
    JTextArea jta  = new JTextArea();

    public void intiDisplay(){
        // 이벤트 소스와 이벤트 처리르 담당하는 핸들러 클래스를 맵핑하기
        // 이 코드가 있어야 actionPerformed()를 호출 합니다.
        btn_ins.addActionListener(this);
        btn_upd.addActionListener(this);
        btn_det.addActionListener(this);
        btn_del.addActionListener(this);

        jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
        jp_north.add(jtf);
        jp_south.add(btn_ins);
        jp_south.add(btn_upd);
        jp_south.add(btn_det);
        jp_south.add(btn_del);
//        jp_center.add(BorderLayout.CENTER, jta);
//        jp_center.add(jta);

        this.setLayout(new BorderLayout());
        this.add(jta, BorderLayout.CENTER);
        this.add(jp_north, BorderLayout.NORTH);
        this.add(jp_south, BorderLayout.SOUTH);

        this.add("North", jp_north);
        this.setTitle("공지사항");
        this.setSize(600,500);
        this.setVisible(true);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        NoticeMain_10_17 nm = new NoticeMain_10_17();
        nm.intiDisplay();
    }
    /* 콜백 메서드의 파라미터 자리에 오는 클래스는 절대로
    개발자가 인스턴스화 하지 않습니다.*/
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Object obj = e.getSource();
//        NoticeSub_10_17 ns = new NoticeSub_10_17();
//        System.out.println("actionPerformed : \n" + ns);
        /* 버튼이 눌릴 때 마다 인스턴스화가 된다. 이 말은 버튼을 네번 누르면
        인스턴스화가 4번 일어난다. 괜찮나? */

        if(obj == btn_ins){ //너 입력버튼 누른거야?
            // 부모창이 실해오디면 자손 창도 일단 메모리에 로딩을 미리 해둔다.
            // 다만 화면에만 보이지 않도록 비활성화 한다. setVisible(false)
            ns.setTitle(btn_ins.getText());
            ns.initDisplay();
//            ns.setSize(600,500);
            this.setVisible(false);
            ns.setVisible(true);
        }
        else if(obj == btn_upd){ // 혹시 수정하려고?
            ns.setTitle(btn_upd.getText());
            ns.initDisplay();

            ns.setVisible(true);
        }
        else if(obj == btn_det){ // 상세내용 보고싶니?
            ns.setTitle(btn_det.getText());
            ns.initDisplay();

            ns.setVisible(true);
        }
        else if(obj == btn_del){ // 삭제하고 싶어?
            ns.setTitle(btn_del.getText());

            ns.setVisible(true);
        }
        else if(obj == ns.btn_save){
            ns.setVisible(true);
        }
    }
}
