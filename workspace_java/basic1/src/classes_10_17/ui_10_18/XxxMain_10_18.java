package classes_10_17.ui_10_18;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XxxMain_10_18 extends JFrame implements ActionListener {
    XxxSub_10_18 xxxSub = new XxxSub_10_18(this);
    // 선언부
    JPanel jp_north = new JPanel();
    JButton jb_ins = new JButton("입력");
    JButton jb_upd = new JButton("수정");
    JButton jb_det = new JButton("상세보기");
    JButton jb_del = new JButton("삭제");
    JButton jb_sel = new JButton("전체조회");
    JButton jb_exit = new JButton("종료");

    //테이블 그리기
    String[] cols = {"번호" , "제목", "작성자"};
    DefaultTableModel dtm = new DefaultTableModel(cols, 3);
    JTable jtb = new JTable(dtm);
    JScrollPane jsp = new JScrollPane(jtb);

    // 생성자
    public XxxMain_10_18(){
        initDisplay();
    }

    // 화면처리부
    public void initDisplay(){
        jb_ins.addActionListener(this);
        jb_upd.addActionListener(this);
        jb_det.addActionListener(this);
        jb_del.addActionListener(this);
        jb_sel.addActionListener(this);
        jb_exit.addActionListener(this);

        jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
        jp_north.add(jb_ins);
        jp_north.add(jb_upd);
        jp_north.add(jb_det);
        jp_north.add(jb_del);
        jp_north.add(jb_sel);
        jp_north.add(jb_exit);

        this.add("North", jp_north);
        this.add("Center", jsp);
        this.setSize(800, 600);
        this.setVisible(true);
    }
    
    // 메인메서드
    public static void main(String[] args) {
        new XxxMain_10_18();
    }
    
    public void xxxList(){
        System.out.println("xxxList 호출");
        
        // 2차원 배열 - 로우가 3이고 컬럼이 3인 경우
        Object[][] objs = {
                {1, "공지사항. 1 ", "관리자"},
                {2, "공지사항. 2 ", "김유신"},
                {3, "공지사항. 3 ", "강감찬"}
        };
        Container cont = this.getContentPane();
        if (jsp != null){ // null이 아니면 참조하는 객체가 있다.
            cont.remove(jsp);
        }
        dtm = new DefaultTableModel(objs, cols);
        jtb = new JTable(dtm);
        jsp = new JScrollPane(jtb);
        this.add("Center", jsp);
        cont.revalidate();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if(obj == jb_ins){ //입력 버튼 눌렀을 때
            xxxList();
//            xxxSub.setTitle(jb_ins.getText());
//            xxxSub.setSize(400,600);
//            xxxSub.setVisible(true);
        }
        else if(obj == jb_upd){ //수정 버튼 눌렀을 때
            xxxList();
//            xxxSub.setTitle(jb_upd.getText());
//            xxxSub.setSize(400,600);
//            xxxSub.setVisible(true);
        }
        else if(obj == jb_det){ //상세보기 버튼 눌렀을 때
            xxxList();
//            xxxSub.setTitle(jb_det.getText());
//            xxxSub.setSize(400,600);
//            xxxSub.setVisible(true);
        }
        else if(obj == jb_del){ //삭제 버튼 눌렀을 때
            xxxList();
//            xxxSub.setTitle(jb_del.getText());
//            xxxSub.setSize(400,600);
//            xxxSub.setVisible(true);
        }
        else if(obj == jb_sel){ //전체조회 버튼 눌렀을 때
            xxxList();
//            xxxSub.setTitle(jb_sel.getText());
//            xxxSub.setSize(400,600);
//            xxxSub.setVisible(true);
        }
        else if(obj == jb_exit){ //종료버튼 눌렀을 때
            xxxList();
//            xxxSub.setTitle(jb_exit.getText());
//            xxxSub.setSize(400,600);
//            xxxSub.setVisible(true);
            this.dispose();
        }
    }
}
