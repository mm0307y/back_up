package athread_10_21.setp1_11_08;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//테스트 시나리오 작성해 보기
public class LoginApp_11_08 extends JFrame implements ActionListener {
    String nickName = "데모용";
    JPanel jp_login = new JPanel(null);
    JTextField jtf_id = new JTextField(){
        @Override
        public void setBorder(Border border) {

        }
    };

    JPasswordField jtf_pw = new JPasswordField(){
        @Override
        public void setBorder(Border border){
        }
    };

    JLabel jlb_join = new JLabel();//회원가입 라벨버튼
    JLabel jlb_infomissing = new JLabel();
    Font f_join = new Font("맑은 고딕", Font.PLAIN, 12);
    String imgPath = "D:\\Java\\workspace_java\\basic1\\src\\image\\profile\\";
    ImageIcon img_logo = new ImageIcon(imgPath+"default_profile.png");
    JButton jbtn_main = new JButton(img_logo);
    JButton jbtn_login = new JButton("로그인");
    KiwiClient_11_08 kc = new KiwiClient_11_08(this);

    public LoginApp_11_08() {
        initDisplay();
    }
    public void initDisplay() {
        jbtn_main.setBorderPainted(false);//테두리 없애기
        jbtn_main.setContentAreaFilled(false);//배경 없애기
        jbtn_main.setFocusPainted(false);//포커스테두리 없애기
        jbtn_login.setBackground(new Color(64,64,64));
        jbtn_login.setForeground(Color.white);
        jbtn_login.setFocusPainted(false);
        jbtn_login.setBorderPainted(false);
        //바나나 이미지 정의
        jbtn_main.setBackground(new Color(253,220,81));
        jbtn_main.setBorderPainted(false);
        jbtn_main .setBounds(60,35, 270, 250);
        jp_login.setBackground(new Color(253,220,81));
        jtf_id.setBounds(60,300, 270, 45);
        jtf_pw.setBounds(60,340, 270, 45);
        jtf_pw.setEchoChar('♣');
        jbtn_login.setBounds(60,400, 270, 45);
        //아이디/비밀번호 찾기 라벨 버튼
        jlb_infomissing.setText("<HTML><U>ID/PW 분실</U></HTML>");
        jlb_infomissing.setForeground(Color.BLACK);
        jlb_infomissing.setFont(f_join);
        jlb_infomissing.setBounds(280,500,200,20);
        jlb_join.setText("<HTML><U>회원가입</U></HTML>");
        jlb_join.setForeground(Color.BLACK);
        jlb_join.setBounds(30,500,150,20);
        jp_login.add(jtf_id);
        jp_login.add(jtf_pw);
        jp_login.add(jbtn_main);
        jp_login.add(jbtn_login);
        jp_login.add(jlb_infomissing);
        jp_login.add(jlb_join);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(jp_login);
        this.setTitle("로그인");
        this.setSize(400, 600);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //로그인 처리합니다.
        nickName = "키위";
    }

    public static void main(String[] args) {
        new LoginApp_11_08(); //21 -> 9메모리 로딩
    }
}
